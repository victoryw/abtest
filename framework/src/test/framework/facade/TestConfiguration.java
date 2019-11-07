package com.victoryw.refactor.test.framework.facade;

public class TestConfiguration implements CbsConfigruation {


    @Override
    public String getCbsBaseLinePath() {
        return "/Users/victoryw/myfiles/worksspace/abJavaTest/baseline/baseline.jar";
    }

    @Override
    public String getCbsBaseLineDependenciesPath() {
        return "/Users/victoryw/myfiles/worksspace/abJavaTest/baseline/target";
    }

    @Override
    public String getCbsBaseLineConfigPath() {
        return null;
    }

    @Override
    public String getCbsRefactorConfigPath() {
        return null;
    }

    @Override
    public String getCbsConfigFilePath() {
        return null;
    }

    @Override
    public String getCbsEnvClassPath() {
        return null;
    }

    @Override
    public String getCbsReloadConfig() {
        return null;
    }
}
