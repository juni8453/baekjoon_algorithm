SELECT ins.NAME, ins.DATETIME
FROM ANIMAL_INS ins
         LEFT JOIN ANIMAL_OUTS outs
                   ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE outs.DATETIME IS NULL
ORDER BY ins.DATETIME
    LIMIT 3


# 보호 테이블 기준으로 LEFT JOIN 실시
# -> 보호 테이블에는 존재하지만, 입양일 테이블에는 존재하지 않는 데이터 식별
# -> 즉, 아직 입양가지 못한 동물 리스트
# -> 입양일 테이블의 모든 값이 비어있으니, 아무거나 골라서 IS NULL 을 WHERE 절로 필터링