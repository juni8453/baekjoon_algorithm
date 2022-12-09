SELECT ins.ANIMAL_ID, ins.ANIMAL_TYPE, ins.NAME
FROM ANIMAL_INS ins
    JOIN ANIMAL_OUTS outs ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE ins.SEX_UPON_INTAKE != outs.SEX_UPON_OUTCOME
ORDER BY ins.ANIMAL_ID ASC

# 보호소에 들어올 당시 중성화 x, 입양 시 중성화 된 동물 목록 조회
# 아이디 순으로 조회
# 중성화 x = Intact
# 중성화 o = Spayed or Neutered