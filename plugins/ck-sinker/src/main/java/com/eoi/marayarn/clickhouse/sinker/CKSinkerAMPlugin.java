package com.eoi.marayarn.clickhouse.sinker;

import com.eoi.marayarn.ApplicationMasterPlugin;
import com.eoi.marayarn.ExecutorHook;
import com.eoi.marayarn.MaraApplicationMaster;
import com.eoi.marayarn.http.HandlerFactory;

import static com.eoi.marayarn.MaraApplicationMaster.GRAFANA_DASHBOARD_ID_ENV_KEY;

public class CKSinkerAMPlugin implements ApplicationMasterPlugin {

    private MaraApplicationMaster applicationMaster;

    @Override
    public String name() {
        return "ck-sinker";
    }

    @Override
    public String grafanaDashboardId() {
        return System.getenv(GRAFANA_DASHBOARD_ID_ENV_KEY);
    }

    @Override
    public HandlerFactory handlerFactory() {
        return new CKSinkerAMHandlerFactory(applicationMaster);
    }

    @Override
    public ExecutorHook getExecutorHook() {
        return new CKSinkerExecutorHook(this.applicationMaster);
    }

    @Override
    public void start(MaraApplicationMaster applicationMaster) {
        this.applicationMaster = applicationMaster;
    }

    @Override
    public void stop() {
        return;
    }
}
