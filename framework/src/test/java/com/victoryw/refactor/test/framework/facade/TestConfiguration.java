package com.victoryw.refactor.test.framework.facade;



public class TestConfiguration implements ProjectConfigruation {


    private String baseLineJarPath = "../baseline_code/build/libs/baseline_code.jar";
    private String baseLineDependencePath = "../baseline_code/build/target/deps";

    @Override
    public String getProjectBaseLinePath() {
        return baseLineJarPath;
    }

    @Override
    public String getProjectBaseLineDependenciesPath() {
        return baseLineDependencePath;
    }

    @Override
    public String getProjectBaseLineConfigPath() {
        return null;
    }

    @Override
    public String getProjectRefactorConfigPath() {
        return null;
    }

    @Override
    public String getProjectConfigFilePath() {
        return null;
    }

    @Override
    public String getProjectEnvClassPath() {
        return null;
    }

    @Override
    public String getProjectReloadConfig() {
        return null;
    }

    public void setBaseLineJarPath(String string) {
        this.baseLineJarPath = string;
    }

    public void setBaseLineDependencePath(String baseLineDependencePath) {
        this.baseLineDependencePath = baseLineDependencePath;
    }
}
