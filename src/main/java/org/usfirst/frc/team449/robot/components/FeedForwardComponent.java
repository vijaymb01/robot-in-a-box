package org.usfirst.frc.team449.robot.components;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jetbrains.annotations.NotNull;
import org.usfirst.frc.team449.robot.jacksonWrappers.FPSTalon;

import java.util.function.DoubleUnaryOperator;

/**
 * A component for calculating feedforwards for a Talon. Takes the setpoint and returns the correct F value.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "@class")
public abstract class FeedForwardComponent implements DoubleUnaryOperator{

    /**
     * The talon this controls the feedforward for.
     */
    protected FPSTalon talon;

    /**
     * Set the talon to get information from. This is a setter instead of being in the constructor to avoid circular referencing.
     * @param talon The talon this controls the feedforward for.
     */
    public void setTalon(@NotNull FPSTalon talon){
        this.talon = talon;
    }

    /**
     * Calculate the voltage for a setpoint in MP mode with
     * @param positionSetpoint
     * @param velSetpoint
     * @param accelSetpoint
     * @return
     */
    public abstract double calcMPVoltage(double positionSetpoint, double velSetpoint, double accelSetpoint);

    /**
     * Calculate the feedforward for the given input.
     *
     * @param operand the setpoint, in feet, feet/sec, feet/sec^2, etc.
     * @return the feedforward (kF gain) to use for that input.
     */
    @Override
    public abstract double applyAsDouble(double operand);
}
