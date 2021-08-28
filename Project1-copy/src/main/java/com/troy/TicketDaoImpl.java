//package com.troy;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TicketDaoImpl implements TicketDAO{
//
//	@Override
//	public void addTicket(Ticket ticket) throws SQLException {
//		String sql = "insert into tickets (emp_id, reimbursement_type, reimbusre_amount, status) values (?,?,?,?)";
//		PreparedStatement ps = connection.prepareStatement(sql);
//		ps.setInt(1, ticket.getEmpId());
//		ps.setString(2, ticket.getrType());
//		ps.setDouble(3, ticket.getrAmount());
//		ps.setString(4, ticket.getStatus());
//		int count = ps.executeUpdate();
//		if (count > 0 ) {
//			System.out.println("New Reimbursement Ticket Added");
//		}else {
//			System.out.println("Incorrect Entry");
//		}
//		
//	}
//
//	@Override
//	public void updateTicket(Ticket ticket) throws SQLException {
//		String sql = "update tickets set emp_id =?, reimbursement_type=?, reimbusre_amount=?, status=? where trans_id = ?";
//		PreparedStatement ps = connection.prepareStatement(sql);
//		ps.setInt(1, ticket.getEmpId());
//		ps.setString(2, ticket.getrType());
//		ps.setDouble(3, ticket.getrAmount());
//		ps.setString(4, ticket.getStatus());
//		ps.setInt(5, ticket.getTransId());
//		
//		int count = ps.executeUpdate();
//		if (count > 0 ) {
//			System.out.println("Reimbursement Ticket Updated");
//		}else {
//			System.out.println("Incorrect Entry");
//		}
//		
//	}
//
//	@Override
//	public void deleteTicket(int id) throws SQLException {
//		String sql="delete from tickets where trans_id = ?";
//		PreparedStatement ps = connection.prepareStatement(sql);
//		ps.setInt(1, id);
//		int count = ps.executeUpdate();
//		if (count > 0 ) {
//			System.out.println("Reimbursement Ticket Removed");
//		}else {
//			System.out.println("Incorrect Entry");
//		}
//		
//	}
//
//	@Override
//	public List<Ticket> getTickets() throws SQLException {
//		String sql = "select * from tickets";
//		List<Ticket> ticket = new ArrayList<>();
//		Statement statement = connection.createStatement();
//		ResultSet rs = statement.executeQuery(sql);
//		while (rs.next()) {
//			int transId = rs.getInt(1);
//			int empId = rs.getInt(2);
//			String rType = rs.getString(3);
//			double rAmount= rs.getDouble(4);
//			String status = rs.getString(5);
//			
//			Ticket tic = new Ticket(transId, empId, rType, rAmount,status);
//			ticket.add(tic);
//		}
//		return ticket;
//	}
//
//	@Override
//	public Ticket getTicketById(int id) throws SQLException {
//		Ticket ticket = new Ticket();
//		String sql = "Select * from ticket where emp_id = " + id;
//		Statement statement = connection.createStatement();
//		ResultSet rs = statement.executeQuery(sql);
//		rs.next();
//		if (rs != null) {
//			int transId = rs.getInt(1);
//			int empId = rs.getInt(2);
//			String rType = rs.getString(3);
//			double rAmount = rs.getDouble(4);
//			String status = rs.getString(5);
//			ticket = new Ticket(transId, empId, rType, rAmount,status);
//		}
//		return ticket;
//	}
//
//}
