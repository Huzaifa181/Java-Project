<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
<style>
* {box-sizing: border-box;}
            ul {list-style-type: none;}
            body {font-family: Verdana, sans-serif;}

            .month {
                padding: 25px 25px;
                width: 100%;
                background: #1087dd;
                text-align: center;
            }

            .month ul {
                margin: 0;
                padding: 0;
            }

            .month ul li {
                color: white;
                font-size: 15px;
                text-transform: uppercase;
                letter-spacing: 3px;
            }

            .month .prev {
                float: left;
                padding-top: 10px;
            }

            .month .next {
                float: right;
                padding-top: 10px;
            }

            .weekdays {
                margin: 0;
                padding: 10px 0;
                background-color: #ddd;
            }

            .weekdays li {
                display: inline-block;
                width: 13.6%;
                color: #666;
                text-align: center;
            }

            .days {
                padding: 10px 0;
                background: #eee;
                margin: 0;
            }

            .days li {
                list-style-type: none;
                display: inline-block;
                width: 13.6%;
                text-align: center;
                margin-bottom: 5px;
                font-size:12px;
                color: #777;
            }

            .days li .active {
                padding: 5px;
                background: #1087dd;
                color: white !important
            }

            /* Add media queries for smaller screens */
            @media screen and (max-width:720px) {
                .weekdays li, .days li {width: 13.1%;}
            }

            @media screen and (max-width: 420px) {
                .weekdays li, .days li {width: 12.5%;}
                .days li .active {padding: 2px;}
            }

            @media screen and (max-width: 290px) {
                .weekdays li, .days li {width: 12.2%;}
            }
</style>
</head>
<body>
<div class="container">
            <!--nav bar-->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item ">
                            <a class="nav-link" href="/CinemaProject/home">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                    </ul >
                    <spring:url value="/logout" var="url_logout"/>
                    <form class="form-inline my-2 my-lg-2">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success mr-sm-2 my-2 my-sm-0" type="submit">Search</button>
                        <a class="mr-sm-2" href="registration" >Logout</a>
                    </form>


                </div>
            </nav>
            <!--jambutan-->
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4">Admin Dashboard</h1>
                   
                </div>
            </div>
            <!--body-->
            <div class="row">
                <div class="col-2 col-md-2">

                    <div class="list-group">
                        <a href="/CinemaProject/about" class="list-group-item list-group-item-action">About</a>
                        <a href="/CinemaProject/classes" class="list-group-item list-group-item-action">Classes</a>                 
                        <a href="/CinemaProject/teacherHome" class="list-group-item list-group-item-action">Teachers Information</a>
                        <a href="/CinemaProject/studentHome" class="list-group-item list-group-item-action">Students Information</a>
                    <a href="/CinemaProject/inputTeacherDetail" class="list-group-item list-group-item-action">Add Teacher</a>
                        <a href="/CinemaProject/inputStudentDetail" class="list-group-item list-group-item-action">Add Student</a>
                    </div>
                    
                    <!--calender--><br/>
                    <div class="month">      
                        <ul>
                            <li class="prev">&#10094;</li>
                            <li class="next">&#10095;</li>
                            <li>
                                June<br>
                                <span style="font-size:12px">2021</span>
                            </li>
                        </ul>
                    </div>

                    <ul class="weekdays">
                        <li>Mo</li>
                        <li>Tu</li>
                        <li>We</li>
                        <li>Th</li>
                        <li>Fr</li>
                        <li>Sa</li>
                        <li>Su</li>
                    </ul>

                    <ul class="days">  
                        <li><span class="active">1</span></li>
                        <li>2</li>
                        <li>3</li>
                        <li>4</li>
                        <li>5</li>
                        <li>6</li>
                        <li>7</li>
                        <li>8</li>
                        <li>9</li>
                        <li>10</li>
                        <li>11</li>
                        <li>12</li>
                        <li>13</li>
                        <li>14</li>
                        <li>15</li>
                        <li>16</li>
                        <li>17</li>
                        <li>18</li>
                        <li>19</li>
                        <li>20</li>
                        <li>21</li>
                        <li>22</li>
                        <li>23</li>
                        <li>24</li>
                        <li>25</li>
                        <li>26</li>
                        <li>27</li>
                        <li>28</li>
                        <li>29</li>
                        <li>30</li>
                        <li>31</li>
                    </ul>

                </div>
                <div class="col-7 col-md-7">
                    <div class="row">
                        <div class="col-4">
                            <div class="card text-center">
                                <div class="card-header">
                                    Total Student
                                </div>
                                <div class="card-body">
                                    <h1 class="card-title">${Tstudent}</h1>
                                </div>
                                <div class="card-footer text-muted">

                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="card text-center">
                                <div class="card-header">
                                    Total Teachers
                                </div>
                                <div class="card-body">
                                    <h1 class="card-title">${Tteacher}</h1>
                                </div>
                                <div class="card-footer text-muted">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                    <br/>
                    
                </div>
            </div>
        </div>
        <script>
           
        </script>
</body>
