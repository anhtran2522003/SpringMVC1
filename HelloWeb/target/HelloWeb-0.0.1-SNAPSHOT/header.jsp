<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- HEADER -->
<header>
	<!-- TOP HEADER -->
	<div id="top-header">
		<div class="container">
			<ul class="header-links pull-left">
				<li><a href="#"><i class="fa fa-phone"></i>${acc == null ? "" : acc.phone}</a></li>
				<li><a href="#"><i class="fa fa-envelope-o"></i>${acc == null ? "Hello there" : acc.name}</a></li>
				<li><a href="#"><i class="fa fa-map-marker"></i>${acc == null ? "" : acc.address}</a></li>
			</ul>
			<ul class="header-links pull-right">

				<c:if test="${acc == null }">
					<li><a href="Register"><i class="fa fa-user-o"></i>Register</a></li>
					<li><a href="Login"><i class="fa fa-user-o"></i>Login</a></li>
				</c:if>
				<c:if test="${acc != null}">
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"
							style="background-color: black">
							<i class="fa fa-user-o"></i>${acc.usr }</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<div>
								<a class="dropdown-item" href="#">Profile</a>
							</div>
							<div>
								<a class="dropdown-item" href="#"> My Orders </a>
							</div>
							<c:if test="${acc != null}">
								<div>
									<a class="dropdown-item" href="admin/index.jsp">Comback
										Admin page</a>
								</div>
							</c:if>
							<div>
								<a class="dropdown-item" href="/PRJ321/Logout">Log out</a>
							</div>
						</div>
					</div>
				</c:if>



			</ul>
		</div>
	</div>
	<!-- /TOP HEADER -->

	<!-- MAIN HEADER -->
	<div id="header">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- LOGO -->
				<div class="col-md-3">
					<div class="header-logo">
						<a href="${pageContext.request.contextPath}/Home" class="logo">
							<img src="./img/logo.png" alt="">
						</a>
					</div>
				</div>
				<!-- /LOGO -->

				<!-- SEARCH BAR -->
				<div class="col-md-6">
					<div class="header-search">
						<form action="${pageContext.request.contextPath}/Search?"
							method="post">
							<select class="input-select">
								<option value="0">All Categories</option>
								<option value="1">Apple</option>
								<option value="2">Samsung</option>
								<option value="3">Xiaomi</option>
								<option value="4">Oppo</option>
								<option value="5">Nokia</option>
								<option value="6">Vsmart</option>
							</select> <input class="input" placeholder="Search here" name="txtSearch"
								value="${txtSearch}">
							<button class="search-btn">Search</button>
						</form>
					</div>
				</div>
				<!-- /SEARCH BAR -->

				<!-- ACCOUNT -->
				<div class="col-md-3 clearfix">
					<div class="header-ctn">
						<!-- Wishlist -->
						<div>
							<a href="#"> <i class="fa fa-heart-o"></i> <span>Your
									Wishlist</span>
								<div class="qty">2</div>
							</a>
						</div>
						<!-- /Wishlist -->

						<!-- Cart -->
						<div class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown"
								aria-expanded="true"> <i class="fa fa-shopping-cart"></i> <span>Your
									Cart</span>
								<div class="qty">
									<c:choose>
										<c:when test="${cart == null}">0</c:when>
										<c:when test="${cart != null}">${cart.numProducts()}</c:when>
									</c:choose>
								</div>
							</a>
							<div class="cart-dropdown">
								<div class="cart-list">
									<c:forEach var="o" items="${cart.items}">
										<div class="product-widget">
											<div class="product-img">
												<img src="${o.src }" alt="">
											</div>
											<div class="product-body">
												<h3 class="product-name">
													<a href="#">${o.name }</a>
												</h3>
												<h4 class="product-price">
													<span class="qty">${o.number} </span>$${o.price }
												</h4>
											</div>
											<button class="delete">
												<i class="fa fa-close"></i>
											</button>
										</div>
									</c:forEach>

								</div>
								<div class="cart-summary">
									<small> <c:choose>
											<c:when test="${cart == null}">0</c:when>
											<c:when test="${cart != null}">${cart.numProducts()}</c:when>
										</c:choose> Item(s) selected
									</small>
									<h5>SUBTOTAL: $ ${cart.getAmount() }</h5>
								</div>

								<div class="cart-btns">
									<a href="cart.jsp">View Cart</a> 
									<a href="Pay">Checkout <i
										class="fa fa-arrow-circle-right"></i></a>
								</div>
							</div>
						</div>
						<!-- /Cart -->

						<!-- Menu Toogle -->
						<div class="menu-toggle">
							<a href="#"> <i class="fa fa-bars"></i> <span>Menu</span>
							</a>
						</div>
						<!-- /Menu Toogle -->
					</div>
				</div>
				<!-- /ACCOUNT -->
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</div>
	<!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->

<!-- NAVIGATION -->
<nav id="navigation">
	<!-- container -->
	<div class="container">
		<!-- responsive-nav -->
		<div id="responsive-nav">
			<!-- NAV -->
			<ul class="main-nav nav navbar-nav">
				<li class="active"><a href="Home">Home</a></li>
				<li><a href="#">Hot Deals</a></li>
				<li><a href="/PRJ321/Categories">Categories</a></li>
				<li><a href="#">Laptops</a></li>
				<li><a href="#">Smartphones</a></li>
				<li><a href="#">Cameras</a></li>
				<li><a href="#">Accessories</a></li>

			</ul>
			<!-- /NAV -->
		</div>
		<!-- /responsive-nav -->
	</div>
	<!-- /container -->
</nav>
<!-- /NAVIGATION -->
