<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
  <link rel="shortcut icon" type="image/x-icon" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/common/favicon22c41b.ico" />
  <meta name="apple-mobile-web-app-capable" content="yes" />
  <meta name="apple-mobile-web-app-status-bar-style" content="black" />
  <meta name="format-detection" content="telephone=no" />
  <script type="text/javascript">
    var uin = "ODEwMzU4NjAx";
    var key = "c468684b929d2be280b7971d27c719fb422c8dc847ef8b043e87598b538facebbc19d905803e2b3324b7fc4c6b51edaa";
    var pass_ticket = "78fxS+TulxTVIx83azrm76dLsLsd5SN4DE3jVS+05l09+AZn2G7u+k9lzCDVw7j3";

String.prototype.html= function(encode) {
    var replace =["&#39;", "'", "&quot;", '"', "&nbsp;", " ", "&gt;", ">", "&lt;", "<", "&amp;", "&", "&yen;", "¥"];
    //console.log(replace);
    if(encode){
        replace.reverse();
    }
    for (var i=0,str=this;i< replace.length;i+= 2){
         str=str.replace(new RegExp(replace[i],'g'),replace[i+1]);
    }
    
    return str;
};
pass_ticket = encodeURIComponent(pass_ticket.html(false).html(false).replace(/\s/g,"+"));
</script> 
  <title>Beacon's&nbsp;Diary</title> 
  <!-- <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve262c35.css" /> -->
  <style>         </style>
  <!--[if lt IE 9]><link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_pc262c35.css"><![endif]-->
  <script type="text/javascript">
    <!-- document.domain = "qq.com"; -->
</script> 
 </head> 
 <body id="activity-detail" class="zh_CN mm_appmsg" ontouchstart=""> 
  <script type="text/javascript">
        var write_sceen_time = (+new Date());
        <!--(sampling) && ((new Image()).src = "http://isdspeed.qq.com/cgi-bin/r.cgi?flag1=7839&flag2=7&flag3=8&16=1000&r=" + Math.random());-->
    </script> 
  
  <div id="js_article" class="rich_media"> 
   <div id="js_top_ad_area" class="top_banner"> 
   </div> 
   <div class="rich_media_inner"> 
    <div id="page-content"> 
     <div id="img-content" class="rich_media_area_primary"> 
      <h2 class="rich_media_title" id="activity-name"> qiqi's&nbsp;日记 </h2> 
      <div class="rich_media_meta_list"> 
       <em id="post-date" class="rich_media_meta rich_media_meta_text">2015-06-05</em> 
       <a class="rich_media_meta rich_media_meta_link rich_media_meta_nickname" href="javascript:void(0);" id="post-user">呆呆日记</a> 
      </div> 
      <!-- <div class="rich_media_thumb_wrp" id="media"> 
       <script>
                            (function(){
                                var cover = "http://mmbiz.qpic.cn/mmbiz/zkcSFczRic6MHibkRFNPyvNrkHdzWGiajPMTkdNt9JaeVMBN9z6NVOAP9dKX3ia9l6vuibR0MfAIebKMjN9m3nb3f2A/0?wx_fmt=jpeg";
                                document.write('<img class="rich_media_thumb" id="js_cover" onerror="this.parentNode.removeChild(this)" data-src="' + cover + '" />');
                            })();
                        </script> 
      </div>  -->
      
      <div class="rich_media_content" id="js_content">
       <p class="text">日记开始</p>
       
       <c:forEach items="${content}" var="diary" varStatus="s"> 
       		<c:if test="${diary.msgType == 'text'}">
       			<p class="text">${diary.content}</p>
       			<p class="text"> </p>
       		</c:if>
       		<c:if test="${diary.msgType== 'image'}">
       		<%-- <img data-src="http://xqpublicread.oss-cn-shenzhen.aliyuncs.com/${diary.mediaId}" data-s="300,640" data-ratio="0.995" data-w="200" /> --%>
       		<!-- <p style="text-align: center;"><img src="/image/get/${diary.mediaId}" /></p>  -->
       			
       			<p style="text-align: center;"><img src="http://xqpublicread.oss-cn-shenzhen.aliyuncs.com/${diary.mediaId}" /></p> 
       			<p class="text"> </p>
       		</c:if>
       </c:forEach>
       
       <p class="text">日记结束</p>
       <p></p>
       <p><span style="color: rgb(165, 165, 165);">来源 | qiqi</span></p>
       <p style="text-align: center; white-space: normal;"><span style="color: rgb(166, 166, 166); font-family: 黑体; font-size: 12px;">——————————————————————</span></p>
       <p style="text-align: center; white-space: normal;"><span style="color: rgb(166, 166, 166); font-family: 黑体; font-size: 12px;">qiqi出品</span></p>
       <p style="text-align: center; white-space: normal;"><span style="color: rgb(166, 166, 166); font-family: 黑体; font-size: 12px;">可爱&middot;漂亮的老婆</span></p>
       <p style="text-align: center; white-space: normal;"><span style="color: rgb(166, 166, 166); font-family: 黑体; font-size: 12px;">我们要一起走完这幸福的一辈子</span></p>
       <p style="text-align: center; white-space: normal;"><span style="color: rgb(166, 166, 166); font-family: 黑体; font-size: 12px;">陪伴，是最长情的告白</span></p>
       <p style="text-align: center; white-space: normal;"><span style="font-family: Arial, sans-serif;"></span></p>
       <p style="text-align: center; white-space: normal;"><span style="color: rgb(166, 166, 166); font-family: 黑体; font-size: 12px;">微信号：qiqi</span></p>
       <p style="text-align: center; white-space: normal;"><span style="color: rgb(166, 166, 166); font-family: 黑体; font-size: 12px;">爱老婆 爱生活</span></p>
       <p> </p>
       <p></p>
      </div> 
      <script type="text/javascript">
                        var first_sceen__time = (+new Date());
                    </script> 
      <!-- <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_combo262c35.css" /> --> 
      <div class="rich_media_tool" id="js_toobar"> 
       <div id="js_read_area" class="media_tool_meta tips_global meta_primary" style="display:none;">
        阅读 
        <span id="readNum"></span>
       </div> 
       <span style="display:none;" class="media_tool_meta meta_primary tips_global meta_praise" id="like"> <i class="icon_praise_gray"></i><span class="praise_num" id="likeNum"></span> </span> 
       <a id="js_report_article" style="display:none;" class="media_tool_meta tips_global meta_extra" href="javascript:void(0);">举报</a> 
      </div> 
     </div> 
     <div class="rich_media_area_extra"> 
      <div class="mpda_bottom_container" id="js_bottom_ad_area"></div> 
      <div id="js_iframetest" style="display:none;"></div> 
     </div> 
    </div> 
    <div id="js_pc_qr_code" class="qr_code_pc_outer" style="display:none;"> 
     <div class="qr_code_pc_inner"> 
      <div class="qr_code_pc"> 
       <img id="js_pc_qr_code_img" class="qr_code_pc_img" /> 
       <p>微信扫一扫<br />关注该公众号</p> 
      </div> 
     </div> 
    </div> 
   </div> 
  </div> 
  <script>window.moon_map = {"a/gotoappdetail.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/gotoappdetail260530.js","a/ios.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/ios24a769.js","a/android.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/android22772d.js","a/profile.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/profile260530.js","biz_common/utils/report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/report224ef3.js","biz_common/utils/cookie.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/cookie224ef3.js","pages/report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/report25ded2.js","pages/love_comment.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/love_comment262c35.js","biz_wap/utils/localstorage.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/localstorage25ded2.js","biz_wap/utils/qqmusic_player.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/qqmusic_player25ded2.js","appmsg/reward_entry.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/reward_entry25de14.js","appmsg/comment.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/comment260530.js","appmsg/like.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/like2340dc.js","appmsg/a.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/a260530.js","pages/version4video.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/version4video262c35.js","biz_common/tmpl.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/tmpl224ef3.js","biz_common/ui/imgonepx.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/ui/imgonepx224ef3.js","biz_common/dom/attr.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/dom/attr22f190.js","biz_wap/utils/ajax.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/ajax25888e.js","biz_common/utils/string/html.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/string/html224ef3.js","appmsg/report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/report23c757.js","biz_common/dom/class.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/dom/class236751.js","appmsg/report_and_source.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/report_and_source23a582.js","appmsg/page_pos.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/page_pos2620a7.js","appmsg/cdn_speed_report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/cdn_speed_report224ef3.js","appmsg/qqmusic.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/qqmusic262c35.js","appmsg/iframe.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/iframe262c35.js","appmsg/review_image.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/review_image2480be.js","appmsg/outer_link.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/outer_link25ded2.js","biz_wap/jsapi/core.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/core25ded2.js","biz_common/dom/event.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/dom/event24f08a.js","appmsg/copyright_report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/copyright_report261b9c.js","appmsg/async.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/async25ffc9.js","biz_wap/ui/lazyload_img.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/ui/lazyload_img23354e.js","biz_common/log/jserr.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/log/jserr22589f.js","appmsg/share.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/share25ded2.js","biz_wap/utils/mmversion.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/mmversion224ef3.js","appmsg/cdn_img_lib.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/cdn_img_lib23c757.js","biz_common/utils/url/parse.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/url/parse25b6ff.js","appmsg/index.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/index261b9c.js"};</script>
  <script type="text/javascript" src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/moon230eaa.js"></script> 
  
  
 </body>
</html>