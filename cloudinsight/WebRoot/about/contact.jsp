<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <div class="contact" >
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h1>联系我们</h1>
                        <h3></h3>
                         <div class="divider"></div>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->
    </div>  
<div class="content-section-b">
<div class="container">
 <div class="row">
        <div class="col-lg-8">
          <h3>给我们留言</h3>
          <form name="sentMessage" id="contactForm" novalidate="">
            <div class="control-group form-group">
              <div class="controls">
                <label>称呼:</label>
                <input type="text" class="form-control" id="name" required="" data-validation-required-message="Please enter your name.">
                <p class="help-block"></p>
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>电话:</label>
                <input type="tel" class="form-control" id="phone" required="" data-validation-required-message="Please enter your phone number.">
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>邮箱:</label>
                <input type="email" class="form-control" id="email" required="" data-validation-required-message="Please enter your email address.">
              </div>
            </div>
            <div class="control-group form-group">
              <div class="controls">
                <label>留言:</label>
                <textarea rows="10" cols="100" class="form-control" id="message" required="" data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"></textarea>
              </div>
            </div>
            <div id="success"></div>
            <!-- For success/fail messages -->
            <button type="submit" class="btn btn-primary">发送</button>
          </form>
        </div>
      </div>
      <!-- /.row -->   
      </div>
      </div>