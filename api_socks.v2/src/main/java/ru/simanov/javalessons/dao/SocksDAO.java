package ru.simanov.javalessons.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.simanov.javalessons.entities.Sock;

@Component
public class SocksDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SocksDAO() {
	}
	
	@Transactional
	public Sock findById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Sock.class, id);
	}
	
	@Transactional
	public Optional<Sock> findByColorAndCottonPart(String color, int cottonPart) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Query<Sock> query = session.createQuery("select new " + Sock.class.getName()
				   								+ "(s.id, s.color, s.cottonPart, s.quantity) "
				   								+ "from " + Sock.class.getName() + " s where cotton_part = :cotton_part and color = :color", Sock.class);
		query.setParameter("cotton_part", cottonPart);
		query.setParameter("color", color);
		
		return query.uniqueResultOptional();
	}
	
	@Transactional
	public void saveSock(Sock sock) {
		Sock newSock = this.findById(sock.getId());
		
		if (newSock == null) {
			this.createSock(sock);
		} else {
			newSock.setQuantity(sock.getQuantity());
		}
	}
	
	@Transactional
	private void createSock(Sock sock) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(sock);
	}
}
