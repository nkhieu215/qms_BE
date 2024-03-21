package com.fn.qms.command;

import java.util.ArrayList;
import java.util.List;

import com.fn.qms.utils.Utils;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.constant.Constant;
import com.fn.qms.planning.model.Condition;
import com.fn.qms.planning.model.Filter;
import com.fn.qms.planning.rest.PlanningFilterInput;
import com.fn.qms.planning.rest.WorkOderInput;
import com.fn.qms.planning.service.PlanningService;
import com.fn.qms.rest.OitmResponse;
import com.fn.qms.rest.ProductionStepRequest;
import com.fn.qms.rest.ProductionStepResponse;
import com.fn.qms.utils.AppLog;

public class ProductionPlanningAction implements Command {

    @Override
    public boolean execute(Context cntxt) throws Exception {
        AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
        ProcessContext context = (ProcessContext) cntxt;
        Response response = context.getResponse();
        Validator.Result result = Validator.Result.OK;
        ApplicationContext ctx = context.getContext();

        ProductionStepResponse res = new ProductionStepResponse();
        Request request = context.getRequest();
        ProductionStepRequest param = request.getPlanningRequest();

        WorkOderInput input = new WorkOderInput();
        String type = param.getTypeRequest();

        switch (type) {
            case Constant.ACTION_BROWS:
                String name = param.getName();
                String lot = param.getLot();
                String productCode = param.getProductCode();
                String lotNumber = param.getLot();
                String woCode = param.getWoCode();


                List<Condition> lstConFilter = new ArrayList<>();
                Condition con2 = new Condition("workOrderType", "=", "LINE");
                lstConFilter.add(con2);

                if (!Utils.isNull(name)) {
                    Condition nameFiler = new Condition("productName", "contains", name.trim());
                    lstConFilter.add(nameFiler);
                }

                if (!Utils.isNull(productCode)) {
                    Condition lotFilter = new Condition("productCode", "contains", productCode.trim());
                    lstConFilter.add(lotFilter);
                }

                if (!Utils.isNull(lotNumber)) {
                    Condition lotFilter = new Condition("lotNumber", "contains", lotNumber.trim());
                    lstConFilter.add(lotFilter);
                }

                if (!Utils.isNull(woCode)) {
                    Condition woFilter = new Condition("woId", "contains", woCode.trim());
                    lstConFilter.add(woFilter);
                }

                Condition woFilterActive = new Condition("sapWo", "notEmpty", "");
                lstConFilter.add(woFilterActive);

                Filter filter2 = new Filter();
                filter2.setConditions(lstConFilter);

                PlanningFilterInput filterInput2 = new PlanningFilterInput();
                filterInput2.setFilter(filter2);
                filterInput2.setSort("-createTime");

                filterInput2.setLimit(param.getSize());
                filterInput2.setOffset(param.getPage() -1);

                res = PlanningService.getInstall().getWorkOder(filterInput2);
                break;

            case Constant.ACTION_SHOW:
                input.setId(param.getIdOrder());
                res = PlanningService.getInstall().getWorkOderDetail(input);
                break;

            case Constant.ACTION_SHOW_STEP:
                List<Condition> lstCon = new ArrayList<>();
                Condition con = new Condition("workOrder", "=", param.getIdOrder());
                lstCon.add(con);

                Filter filter = new Filter();
                filter.setConditions(lstCon);

                PlanningFilterInput filterInput = new PlanningFilterInput();
                filterInput.setFilter(filter);

                res = PlanningService.getInstall().getUserWorkOrderDetail(filterInput);
                break;

            default:
                break;
        }

        response.setObj(res);
        context.setResult(result);
        return !result.isOk();
    }

}
