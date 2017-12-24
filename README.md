# Fetch-execute
This program is an alternative of simulator(had written on Shockwave)
# About
The simulator allows you to run your own programs and watch the processor's internal registers as the code is executed.
Program needs Java VM https://java.com/en/download/
# Supported commands

## LDA _
Load Accumulator
## STA _
Store content of accumulator
## Add _
Add contents of data bus to the contents of the accumulator
## SUB _
Substract the contents of the data bus to the contents of the accumulator
## IN
Input data from device nn
## OUT
Output data from device nn
## HLT
Halt program execution
## BRA _
Branch always to nn
## BRLT
Branch to nn if the accumulator is less then zero
## BRLE
Branch to nn if the accumulator is equal to or less then zero
## BRGT
Branch to nn if the accumulator is greater then zero
## BRGE
Branch to nn if the accumulator is equal to or greater then zero
## BRNE
Branch to nn if the accumulator is not equal to zero
## LDX _
Load the X index register with the data in the memory location specified
## LDY _
Load the Y index register with the data in the memory location specified
## CPAX
Accumulator to X register
## CPAY
Accumulator to X register
## CPXA
X register to Accumulator
## CPYA
Y register to Accumulator

# Other opportunities
Support *, #, @. But their combination is not supported.
