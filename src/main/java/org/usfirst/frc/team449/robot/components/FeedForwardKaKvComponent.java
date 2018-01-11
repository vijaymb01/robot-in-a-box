package org.usfirst.frc.team449.robot.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

/**
 * A {@link FeedForwardComponent} for use on a drive characterized in the way described in our white paper.
 */
public class FeedForwardKaKvComponent extends FeedForwardComponent{

    private final double kVFwd, kVRev;

    private final double kAFwd, kARev;

    private final double interceptVoltageFwd, interceptVoltageRev;

    @JsonCreator
    public FeedForwardKaKvComponent(@JsonProperty(required = true) double kVFwd,
                                    @Nullable Double kVRev,
                                    double kAFwd,
                                    @Nullable Double kARev,
                                    double interceptVoltageFwd,
                                    @Nullable Double interceptVoltageRev){
        this.kVFwd = kVFwd;
        this.kVRev = kVRev != null ? kVRev : this.kVFwd;
        this.kAFwd = kAFwd;
        this.kARev = kARev != null ? kARev : this.kAFwd;
        this.interceptVoltageFwd = interceptVoltageFwd;
        this.interceptVoltageRev = interceptVoltageRev != null ? interceptVoltageRev : this.interceptVoltageFwd;
    }

    /**
     * Calculate the feedforward for the given input.
     *
     * @param operand the setpoint, in feet, feet/sec, feet/sec^2, etc.
     * @return the feedforward (kF gain) to use for that input.
     */
    @Override
    public double applyAsDouble(double operand) {
        return 0;
    }
}
