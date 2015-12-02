#!/usr/bin/env bash

echo "Part 1"
echo
echo "MMDCDXLIV is " `./numerals MMDCDXLIV`
echo 
echo "Part 2"
echo 


function checkNumeral {
 NUMERAL=$1
 RET=`./numerals ${NUMERAL} 2>&1`
 if [ $? -ne 0 ]; then
  echo "${NUMERAL} is not valid because" 
  echo "  " $RET
 else
    echo "${NUMERAL} is " $RET
 fi
}

checkNumeral VIV
checkNumeral MIX
checkNumeral LID
checkNumeral DIX
checkNumeral LICX
checkNumeral CLIX
checkNumeral MMDLIV
checkNumeral MMXDLIV
checkNumeral MCMXCX
checkNumeral MCMXCVI
