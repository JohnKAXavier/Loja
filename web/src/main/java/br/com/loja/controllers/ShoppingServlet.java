package br.com.loja.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.loja.models.ProductModel;
import br.com.loja.models.ShoppingCart;
import br.com.loja.services.ProductService;

@WebServlet(urlPatterns = {"payment", "shopping-cart"})
public class ShoppingServlet extends HttpServlet {

	@Inject
	private ProductService productService;
	
	@Inject
	private ShoppingCart shoppingCart;
	
	@Resource(lookup = "java:/myjms/Mycon")
	ConnectionFactory connectionFactory;
	
	@Resource(lookup = "java:/myjms/myqueue")
	Destination destination;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProductModel> products = this.shoppingCart.getProducts();
		
		req.setAttribute("products", products);
		
		req.setAttribute("total", this.shoppingCart.getTotal());
		
		req.getRequestDispatcher("WEB-INF/pages/form/payment.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String servletPath = req.getServletPath();
		
		if("/shopping-cart".equals(servletPath)) 
		{
			
			String productId = req.getParameter("productId");
			String action = req.getParameter("action");
			
			Integer id = Integer.valueOf(productId);
			
			if("add".equals(action)) 
			{
				ProductModel product = this.productService.get(id);
				this.shoppingCart.add(product);				
			}else{
				this.shoppingCart.remove(id);
			}
			
		}else 
		{
			try {
				this.submitPayment(this.shoppingCart);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		resp.sendRedirect("products");
	}

	private void submitPayment(ShoppingCart shoppingCart) throws JMSException {
		// TODO Auto-generated method stub
		
		QueueConnection connection = (QueueConnection) connectionFactory.createConnection();
		QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		
		MessageProducer producer = session.createProducer(destination);
		TextMessage message = session.createTextMessage(" Total to pay: " + shoppingCart.getTotal());
		producer.send(message);
		
		producer.close();
		session.close();
		connection.close();
	}
	
}
