package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.entity.*;
import com.dao.ClassDao;
import com.dao.StudentsDao;
import com.dao.SubjectsDao;
import com.dao.TeacherDao;
import com.dao.Validate;
import com.dao.assigncsDao;
import com.dao.assignscDao;
import com.dao.assigntDao;

@WebServlet("/OperationController")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project") // context.xml,connect with database
	private DataSource dataSource;

	public OperationController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = request.getParameter("page");

		switch (page) {

		case "listofteachers":

			listTeacher(request, response);

			break;

		case "listofclass":

			listofclass(request, response);

			break;

		case "listofsubjects":

			listofsubjects(request, response);
			break;

		case "listofstudents":

			listofstudents(request, response);
			break;

		case "assignsubjects":

			assignsubjects(request, response);

			break;

		case "assignstudent":

			assignstudent(request, response);

			break;

		case "assignteachers":

			assignteachers(request, response);

			break;

		default:
			errorPage(request, response);
		}
	}

	private void assignteachers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		session.getAttribute("username");
		request.getRequestDispatcher("assignteacher.jsp").forward(request, response);

	}

	private void assignstudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		session.getAttribute("username");
		request.getRequestDispatcher("classassign.jsp").forward(request, response);

	}

	private void listofstudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		session.getAttribute("username");

		List<Students> students = new StudentsDao().liststudents();
		request.setAttribute("liststudents", students);

		request.getRequestDispatcher("students.jsp").forward(request, response);
	}

	private void assignsubjects(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("assignclass.jsp").forward(request, response);
	}

	private void listofsubjects(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		session.getAttribute("username");

		List<Subjects> subjects = new SubjectsDao().listsubjects();
		request.setAttribute("listsubject", subjects);

		request.getRequestDispatcher("subject.jsp").forward(request, response);

	}

	private void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("error.jsp").forward(request, response);

	}

	private void listofclass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		session.getAttribute("username");
		List<listofclass> classess = new ClassDao().listclass();
		request.setAttribute("listclass", classess);

		request.getRequestDispatcher("class.jsp").forward(request, response);

	}

	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// listing the user
		// first we need the list of user
		HttpSession session = request.getSession(false);
		session.getAttribute("username");

		List<Teacher> teachers = new TeacherDao().listteacher();
		request.setAttribute("listteachers", teachers);

		request.getRequestDispatcher("teachers.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {
		case "subjectclass":

			subjectclass(request, response);

			break;

		case "studentclass":

			studentclass(request, response);

			break;

		case "teacherassign":

			teacherassign(request, response);

			break;

		default:
			break;
		}
	}

	private void teacherassign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		session.getAttribute("username");
		
		int tid=Integer.parseInt(request.getParameter("tid"));
		String tname=request.getParameter("tname");
		String sub=request.getParameter("sub");
		String classname=request.getParameter("classname");
		
		assignt t=new assignt(tid, classname, tname, classname);
		new assigntDao().teacherclass(t);
		request.getRequestDispatcher("panel.jsp").forward(request, response);
		
	}

	private void studentclass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		session.getAttribute("username");

		int rollno = Integer.parseInt(request.getParameter("stdid"));
		String name = request.getParameter("stdname");
		int age = Integer.parseInt(request.getParameter("stdage"));
		String classadd = request.getParameter("classadd");

		assignsc sc = new assignsc(rollno, name, age, classadd);
		new assignscDao().studentclass(sc);
		request.getRequestDispatcher("panel.jsp").forward(request, response);

	}

	private void subjectclass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		session.getAttribute("username");
		int classid = Integer.parseInt(request.getParameter("classid"));
		String sub = request.getParameter("sub");
		assigncs cs = new assigncs(classid, sub);
		new assigncsDao().subjectclass(cs);
		request.getRequestDispatcher("panel.jsp").forward(request, response);

	}

}
