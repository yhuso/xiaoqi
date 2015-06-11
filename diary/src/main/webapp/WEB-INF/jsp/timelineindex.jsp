<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0113)http://www.17sucai.com/preview/1/2015-01-22/html5%E5%93%8D%E5%BA%94%E5%BC%8F%E6%97%B6%E9%97%B4%E8%BD%B4/demo.html -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
<title>Timeline</title>

<link href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" media="all" rel="stylesheet">
<link href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" media="all" rel="stylesheet">

<link href="./timeline/css/styles.css" media="all" rel="stylesheet">

<script>var old = null;function asplay_top(c){var audio = document.createElement("audio");if(audio != null && audio.canPlayType && audio.canPlayType("audio/mpeg")){if(old){old.pause();}audio.src = c;old = audio;audio.play();}}</script></head>
<body>

<div class="timeline animated">
	
	<c:forEach items="${posts}" var="post" varStatus="s">
	<div class="timeline-row ">
		<div class="timeline-time"><small>${post.date}</small>${post.time}</div>
		<div class="timeline-icon">
			<div class="bg-primary"><i class="fa fa-pencil"></i></div>
		</div>
		<div class="panel timeline-content">
			<div class="panel-body">
				<h2>This is a title for this timeline post</h2>
				<p>
				<c:forEach items="${post.texts}" var="text">
				${text}
				</c:forEach>
				</p>
			</div>
		</div>
	</div>
	
	</c:forEach>
	
	
</div>

<script type="text/javascript" src="./timeline/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="./timeline/bootstrap.min.js"></script>
<script type="text/javascript" src="./timeline/main.js"></script>


</body></html>