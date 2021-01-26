package com.wxj.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * <p>@ClassName: ActiveMqUtils  </p>
 * <p>@Description: ActiveMq 发布消息工具类</p>
 * <p>@author: wxj  </p>
 * <p>@date: 2021/1/26</p>
 * <p>@Tel:18772118541</p>
 * <p>@email:18772118541@163.com</p>
 */
@Slf4j
public class ActiveMqUtils {

	/**
	 * 发送队列
	 * 1、创建连接工厂
	 * 2、创建连接
	 * 3、创建session
	 * 4、创建消息对象
	 * 5、通过MessageProducer的setDeliverMode方法为其设置持久化或者非持久化特性
	 * 6、关闭连接
	 */
	public static void sendQueue (String queueName,String content) {
		log.info("ActiveMQ  发送消息");
		try {
			// 1、 创建连接工厂
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
					ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://localhost:61616");
			// 2、创建连接
			Connection connection = connectionFactory.createConnection();

			// 3、 创建session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);


			// 5、使用Session对象创建一个Destination对象。两种形式queue、topic，现在应该使用topic
			Queue queue = session.createQueue(queueName);
			// 6、使用Session对象创建一个Producer对象。
			MessageProducer producer = session.createProducer(queue);
//			session
			// 7、创建一个Message对象，可以使用TextMessage。

			TextMessage textMessage = session.createTextMessage(content);
				// 8、发送消息
			producer.send(textMessage);

			// 9、关闭资源
			producer.close();
			session.close();
			connection.close();
		} catch (Exception e) {

		}

	}


	public static String reciveQueue (String queueName) throws JMSException {
		final String[] result = {""};
		log.info("ActiveMQ  接收消息");
		Connection connection = null;
		Session session = null;
		MessageConsumer consumer = null;
		try {
			// 1、 创建连接工厂
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
					ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://localhost:61616");
			// 2、创建连接

			connection = connectionFactory.createConnection();
			connection.start();
			// 3、 创建session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);


			// 5、使用Session对象创建一个Destination对象。两种形式queue、topic，现在应该使用topic
			Queue queue = session.createQueue(queueName);
			// 6、使用Session对象创建一个Producer对象。
			consumer = session.createConsumer(queue);

			String messageSelector = consumer.getMessageSelector();
			System.out.println("ss："+messageSelector);
			consumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					TextMessage textMessage = (TextMessage) message;
					try {
						String text = textMessage.getText();
						result[0] = text;
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});


		} catch (Exception e) {

		} finally {
			// 9、关闭资源
			if (consumer != null) {
				consumer.close();
			}
			if (session != null) {
				session.close();
			}
			if (connection != null) {
				connection.close();
			}
			 return result[0];
		}

	}

	public static void main(String[] args) throws JMSException {
		String wxjQueue = reciveQueue("wxjQueue");
		log.info("wxjQueue：{}",wxjQueue);
	}
}
