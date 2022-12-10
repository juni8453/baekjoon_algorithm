SELECT ins.ANIMAL_ID, ins.ANIMAL_TYPE, ins.NAME
FROM ANIMAL_INS ins
    JOIN ANIMAL_OUTS outs ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE ins.SEX_UPON_INTAKE != outs.SEX_UPON_OUTCOME
ORDER BY ins.ANIMAL_ID ASC

# 아이디 순으로 조회
# 중성화 x = Intact
# 중성화 o = Spayed or Neutered