<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
            <form  action="authenticate.do" method="post" name="loginform">
                <fieldset>
                    <legend>Login</legend>
                    
                    <div >
                        <label for="name">Email</label>
                        <input type="email" name="email" placeholder="Your Email" id="user-email" required="required"   />
                    </div>

                    <div >
                        <label for="name">Password</label>
                        <input type="password" name="password" placeholder="Your Password" id="user-pass"   />
                    </div>

                    <div>
                        <input type="submit"  value="Login" />
                    </div>
                </fieldset>
            </form>

</body>
</html>