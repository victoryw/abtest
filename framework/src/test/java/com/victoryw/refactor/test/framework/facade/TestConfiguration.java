package com.victoryw.refactor.test.framework.facade;

public class TestConfiguration implements ProjectConfigruation {


    @Override
    public String getProjectBaseLinePath() {
        return "../baseline_code/build/libs/baseline_code.jar";
    }

    @Override
    public String getProjectBaseLineDependenciesPath() {
        return "../baseline_code/build/target/deps";
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
}
