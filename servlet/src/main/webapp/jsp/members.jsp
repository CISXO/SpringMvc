<%@ page import="hellomvc.servlet.domain.member.Member" %>
<%@ page import="hellomvc.servlet.domain.member.MemberRepository" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">main</a>
<table>
    <thread>
        <th>id</th>
        <th>username</th>
        <th>age</th>
    </thread>
    <tbody>
    <%
        for (Member member : members) {
            out.write(" <tr>");
            out.write("     <td> " + member.getId() + "</td>");
            out.write("     <td> " + member.getUsername() + "</td>");
            out.write("     <td> " + member.getAge() + "</td>");
            out.write(" </tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>