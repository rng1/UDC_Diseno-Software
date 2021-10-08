package e4;

import static e4.Calculator.Sign.*;

public record Operation ( Calculator.Sign operator, float value ){}