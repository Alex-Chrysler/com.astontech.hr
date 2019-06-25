<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">
    <%--    SIDEBAR--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post" >
                <fieldset>
                    <legend>Vehicle Management</legend>

                    <div class="form-group">
                        <label class="col-lg-2 control-label">Vehicle Make</label>
                        <div class="col-lg-10">
                            <form:select path="newMake" type="text" class="form-control" id="inputNewMake" placeholder="Make">
                                <option value='0'>Select Vehicle Make</option>
                                <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                                    <c:choose>
                                        <c:when test="${vehicleMake.vehicleMakeId == vehicleMakeId}">
                                            <option selected value="${vehicleMake.vehicleMakeId}">${vehicleMake.vehicleMakeName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${vehicleMake.vehicleMakeId}">${vehicleMake.vehicleMakeName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-2 control-label">Vehicle Model</label>
                        <div class="col-lg-10">
                            <form:select path="newModel" type="text" class="form-control" id="inputNewModel" placeholder="Model">
                                <option value='0'>Select Vehicle Model</option>
                                <c:forEach var="vehicleModel" items="${vehicleModelList}">
                                    <c:choose>
                                        <c:when test="${vehicleModel.vehicleModelId == vehicleModelId}">
                                            <option selected value="${vehicleModel.vehicleModelId}">${vehicleModel.vehicleModelName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${vehicleModel.vehicleModelId}">${vehicleModel.vehicleModelName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="inputNewVehicleYear" class="col-lg-2 control-label">Vehicle Year</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleYear" type="text" cssClass="form-control" id="inputNewVehicleYear" placeholder="Vehicle Year"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehiclelicensePlate" class="col-lg-2 control-label">License Plate</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleLicensePlate" type="text" cssClass="form-control" id="inputNewVehiclelicensePlate" placeholder="License Plate"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleVin" class="col-lg-2 control-label">Vehicle Vin</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleVin" type="text" cssClass="form-control" id="inputNewVehicleVin" placeholder="VIN Number"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleColor" class="col-lg-2 control-label">Vehicle Color</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleColor" type="text" cssClass="form-control" id="inputNewVehicleColor" placeholder="Vehicle Color"></form:input>
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
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>