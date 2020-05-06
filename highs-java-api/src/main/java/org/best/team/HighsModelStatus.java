package org.best.team;

public enum HighsModelStatus {
    NOTSET,
    LOAD_ERROR,
    MODEL_ERROR,
    PRESOLVE_ERROR,
    SOLVE_ERROR,
    POSTSOLVE_ERROR,
    MODEL_EMPTY,
    PRIMAL_INFEASIBLE,
    PRIMAL_UNBOUNDED,
    OPTIMAL,
    REACHED_DUAL_OBJECTIVE_VALUE_UPPER_BOUND,
    REACHED_TIME_LIMIT,
    REACHED_ITERATION_LIMIT
}
