<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>


<div class="wrapper">
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <c:set var="idx" value="0" scope="page" />
            <form:form cssClass="form-horizontal" modelAttribute="vehicle" action="/admin/vehicle/update" method="post">
                <form:hidden path ="id"></form:hidden>
                <form:hidden path="version"></form:hidden>

                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleMake" class="col-sm-2 control-label">Vehicle Make</label>
                        <div class="col-sm-10">
                            <form:input path="vehicleModel.vehicleMake.vehicleMakeName" type="text" id="inputVehicleMake" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleModel" class="col-sm-2 control-label">Vehicle Model</label>
                        <div class="col-sm-10">
                            <form:input path="vehicleModel.vehicleModelName" type="text" id="inputVehicleModel" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleYear" class="col-sm-2 control-label">VehicleYear</label>
                        <div class="col-sm-10">
                            <form:input path="year" type="text" id="inputVehicleYear" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleLicensePlate" class="col-sm-2 control-label">License Plate</label>
                        <div class="col-sm-10">
                            <form:input path="licensePlate" type="text" id="inputVehicleLicensePlate" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="inputNewVehicleVin" class="col-sm-2 control-label">Vin</label>
                        <div class="col-sm-10">
                            <form:input path="vin" type="text" id="inputNewVehicleVin" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="inputNewVehicleColor" class="col-sm-2 control-label">Color</label>
                        <div class="col-sm-10">
                            <form:input path="color" type="text" id="inputNewVehicleColor" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>



                <div class="row">
                    <button class="btn btn-primary">Update</button>
                </div>

            </form:form>

        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>