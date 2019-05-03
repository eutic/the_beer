<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>lager</title>
<link rel="stylesheet" href="css/main.css">
<link href="images/favicon.ico" rel="icon">
<style>
article{padding: 20px ; margin: 10px auto;}
article p {padding: 10px ;margin: 0 auto;}
</style>
</head>
<body>
<div id="wrapper">
<jsp:include page="../common/header.jsp"></jsp:include>
<section>
	
	<article>
	     <img src="images/lager.jpg" >
	     	<h3>Beer</h3>
	     		<p>Lager. 투명한 황금빛과 가볍고 밋밋한 향, 강한 탄산감이 특징이다.
					Lager는 독일의 '저장고'라는 말에서 유래된 것으로, 하면발효 맥주의 특성에서 유래된 것이다. 
					하면발효란 보리를 맥주로 발효시키는 동안 이스트가 바닥에 가라앉는다는 것을 의미한다. 
					현재 주변에서 흔히 볼 수 있는 대부분의 맥주는 이 하면발효 맥주인 라거이다. (세계시장 80% 이상을 차지함)
				</p>
	</article>
	<br>
		<article>
	     <img src="images/pilsner.jpg" >
	     <h4>필스너</h4>
	     <p>체코의 플젠(Pilsen)지방에서 유래된 맥주. 기존의 맥주 제조법을 버리고 당시에도 맥주의 선진국이던 독일에서 새로 라거 제조법을 들여와 체코에서 생산한 맥주가 시초이다.
			 라거 특유의 투명한 황금빛과 시원한 청량감에 더해 사츠(Saaz) 홉의 쌉싸름한 맛과 풍미가 강조된 것이 특징. 일반 라거에 비해 더욱 강한 쓴맛과 깊은 풍미가 보리의 곡물향와 적절한 조화를 이루고, 미디엄 바디감이 특징이다.
		</p>
	</article>
	 
	<article>
	     <img src="images/bud.jpg" >
		     <h4>버드와이저</h4>
			     <p>'King of Beers(맥주의 왕)' 라는 슬로건으로 마케팅하는것이 유명한 미국 맥주.
			   		 미국을 대표하는 맥주로 매년 미국에서 판매량 기준으로 1등을 하는 맥주로 앤하이저부시의 대표적인 맥주이며,
			    	 맥아만 쓰이지 않고 옥수수나 쌀이 들어가는 부가물 라거이다.
				</p>
	 </article>
	 
	 <article>
	     <img src="images/miller.jpg" >
		     <h4>밀러</h4>
			     <p>원료에 옥수수를 (부가물) 첨가한 미국 맥주.
			   		 미국 전체 판매량은 버드와이저(1위)를 뒤이어 2위이다. 밀러 드래프트라고 해서 생 맥주도 판매 중이며, 병 맥주와는 다르게 달달한 맛이 난다.
				 </p>
	 </article>
	 
	 
	 <article>
	     <img src="images/tsing.jpg" >
		     <h4>칭따오</h4>
			     <p>자칫 주류에 관한 지식이 없는 사람들에겐 마데 인 차이나라고 무시당하기 쉽지만, 이래뵈도 역사도 깊고 독일 기술로 주조되어 호평받는 맥주이다. 심지어 역사가 이미 100년이 넘었는데, 
			     1898년 독일 제국이 청나라로부터 받은 칭다오 조계지 키아우초우에서 질 좋은 지하수를 발견하고 1903년 8월 독일인과 영국인이 합작으로 로망 맥주 지분 유한 공사 칭다오 공사를 설립한 것이 시초다.
			     시원한 청량감을 주는 맛이 일품. 물론 독일식 맥주순수령에 따른 라거를 선호하는 이들은 전통적인 물, 맥아, 호프만 가지고 제조하는 여타 라거 맥주들과 달리 쌀이 들어간다는 이유로 좀 밍밍한 맛이라고 비판하는 이들도 있다. 
			     </p>
	 </article>
	 
	 <article>
	     <img src="images/hein.jpg" >
		     <h4>하이네켄</h4>
			     <p>
			    	 네덜란드의 대표적 맥주 브랜드. 축빠라면 UEFA 챔피언스 리그의 메인 스폰서로 더욱 유명한 맥주다.
					증류수와 맥아를 섞은 보리, 효모로만 만들며, 효모는 1886년 것을 지금도 사용중이다. 미국인들이 버드와이저에 비해서 톡쏘는 맛이 없다고 이른바 '오줌'이라고 까기도 하는데 사실 버드와이저는 쌀이 들어간 미국식 부가물 라거 맥주고, 이 쪽은 보리와 물, 홉, 효모등으로만 만드는, 
					역사가 있는 정통 유럽식 라거 맥주인데다가 애당초 톡 쏘는 맛은 그저 탄산으로 인한 것이고 맥주로서는 당연히 하이네켄 쪽이 제맛이다.
					물론 술은 기호품이니 어느 쪽을 선호하든 그건 자유지만, 자랑스럽게 '까는 것은' 그야말로 무식 인증.
			     </p>
	 </article>
	 
	 <article>
	     <img src="images/cass.jpg" >
	     <h4>카스</h4>
	     <p>
			1993년에 먼저 탄생한 하이트맥주와 함께 1990년대를 풍미했던 맥주로, 20년이 다 되어 가는 지금도 하이트와 경쟁 중인데 출시 당시엔 하이트 열풍으로 큰 차이가 났으나 현재는 카스 쪽이 압도하고 있다. 
			지금은 오리지널 외에도 탄수화물 성분을 제거하여 기존 맥주보다 칼로리가 약 33% 정도 감소한 제품인 카스 라이트, 
			이탈리아산 레몬즙이 5%첨가된 카스 레몬, 6.5도의 도수를 가진 알콜 강화 맥주인 카스 레드 등을 출시하고 있다.
	     </p>
	 </article>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>