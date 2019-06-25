<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">
<%--    SIDEBAR--%>
    <%@include file="element_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="elementVO" action="/admin/element/add" method="post" >
                <fieldset>
                    <legend>Element Management</legend>
                    <div class="form-group">
                        <label for="inputNewElementType" class="col-lg-2 control-label">Element Type</label>
                        <div class="col-lg-10">
                            <form:input path="newElementType" type="text" cssClass="form-control" id="inputNewElementType" placeholder="Element Type"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewElements" class="col-lg-2 control-label">Elements</label>
                        <div class="col-lg-10">
                            <form:textarea path="newElements" rows="3" cssClass="form-control" id="inputNewElements"></form:textarea>
                            <span class="help-block">Enter each new Element on a new line.</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>

                </fieldset>
            </form:form>

        </div>

        <div class="col-sm-4">
<%--        ALERTS--%>
        <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
            <div class="alert alert-dismissable alert-success">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>
            </div>
        </div>
        <%--            WARNING ALERT--%>
        <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
            <div class="alert alert-dismissable alert-warning">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <h4>Warning!</h4>
                <p>Best check yo self, you're not looking too good. </p>
            </div>
        </div>
        <%--            ERROR ALERT--%>
        <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="errorAlert">
            <div class="alert alert-dismissable alert-danger">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Oh Snap!</strong><a href="#" class="alert-link"> Change a few things up</a> and try submitting again.
            </div>
        </div>
        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>

