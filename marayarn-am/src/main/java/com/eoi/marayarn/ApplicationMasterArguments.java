package com.eoi.marayarn;

import org.apache.commons.cli.CommandLine;

public class ApplicationMasterArguments {
    public int numExecutors;
    public int executorCores;
    public int executorMemory; //MB
    public String queue;
    public String commandLine;

    private void checkIfNullOrEmpty(String t, String literal) throws InvalidAMArgumentException {
        if (t == null || t.isEmpty()) {
            throw new InvalidAMArgumentException("Invalid null or empty argument " + literal);
        }
    }

    public void checkArguments() throws InvalidAMArgumentException {
        checkIfNullOrEmpty(commandLine, "commandLine");
        if (numExecutors == 0) {
            numExecutors = 1;
        }
        if (executorCores == 0) {
            executorCores = 1;
        }
        if (executorMemory == 0) {
            executorMemory = 256;
        }
    }

    @Override
    public String toString() {
        return "ApplicationMasterArguments{" +
                "numExecutors=" + numExecutors +
                ", executorCores=" + executorCores +
                ", executorMemory=" + executorMemory +
                ", queue='" + queue + '\'' +
                ", commandLine='" + commandLine + '\'' +
                '}';
    }
}
