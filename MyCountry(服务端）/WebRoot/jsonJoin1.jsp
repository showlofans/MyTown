
<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><[url=mailto:%@taglib]%@taglib[/url] uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><?xml version="1.0" encoding="UTF-8"?>
<videonews>
    <c:forEach items="${videos}" var="video">
        <news id ="${video.id }">
            <title>${video.title }</title>
            <timelength>${video.timelenght}</timelength>
        </news>
    </c:forEach>
</videonews>
