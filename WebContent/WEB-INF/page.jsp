<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<a href="${pageContext.request.contextPath}/IndexUI?page=1">首页</a>
					<c:if test="${house.currentPage - 1 >=1 }">
						<a href="${pageContext.request.contextPath}/IndexUI?page=${house.currentPage-1}">上一页</a>
					</c:if>
					<c:forEach var="num" begin="${house.startPage}" end="${house.endPage}" step="1">
						<a href="${pageContext.request.contextPath}/IndexUI?page=${num}">${num}</a>
					</c:forEach>
					<c:if test="${house.currentPage +1 <= house.totalPage}">
						<a href="${pageContext.request.contextPath}/IndexUI?page=${house.currentPage+1}">下一页</a>
					</c:if>
					<a href="${pageContext.request.contextPath}/IndexUI?page=${house.totalPage}">尾页</a>