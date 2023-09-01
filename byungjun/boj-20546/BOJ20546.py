# BOJ 20546

"""
    준현이(JH)의 규칙
    1. 한 번 산 주식은 절대 팔지 않음
    2. 살 수 있다면 무조건 최대한 많이
    3. 주식을 살 수 잇다면 가능한 만큼 즉시 매수

    성민이(SM)의 규칙
    1. 모든 거래는 전량 매수와 전량 매도
    2. 3일 연속 주가 상승시, 전량 매도
    3. 3일 연속 주가 하락시, 전량 매수

    비교
    1월 14일 기준으로, 현금 + 1월 14일의 주가 * 주식 수

    입력:
    1. 준현이와 성민이에게 주어진 현금
    2. 2021.1.1 ~ 2021.1.14 주식 가격

    출력:
    1. 1월 14일 기준으로 준현이의 자산이 더 크다면 BNP
    2. 성민이의 자산이 더 크다면 TIMING
    3. 동일하다면 SAMESAME
"""

"""
    문제풀이
    1. 입력받은 현금과, 주식 가격들을 저장할 변수와 리스트를 생성
    2. 주가의 개수만큼의 반복문을 순회하면서 현금, 보유 주식 수를 저장
        2-1. 준현이는 보유 현금이 주가 보다 작다면, 최대한 많이 구매
        2-2. 성민이는 3일 연속 주가 상승시, 전량 매도하고 하락 시, 전량 매수
        2-3. 3일 주가의 흐름을 파악하기 위해 변수로 구분
    3. 마지막 비교
"""

import sys
input = sys.stdin.readline

# 현금과, 주가 정보들을 입력
money = int(input())
stocks = list(map(int, input().split()))

# JH(준현)와 SM(성민)가 가지고 있는 돈과 보유 주식 수를 튜플 형식으로 저장
JH_wallet = (money, 0)
SM_wallet = (money, 0)

# 상승일자와 하락일자를 나타내는 튜플
state = (0, 0)
# 이전 가격을 확인하기 위한 변수
prev = stocks[0]

# 주가의 개수만큼 반복문을 순회
for stock in stocks:
    if JH_wallet[0] > stock and JH_wallet[0] > 0:
        # JH가 주식을 구매할 수 있다면
        stock_count = JH_wallet[0] // stock # 구매 가능한 주식의 개수

        current_money = JH_wallet[0] - (stock * stock_count) # 주식을 사고 남은 돈
        current_stocks = stock_count + JH_wallet[1] # 이전에 가지고 있는 주식의 개수와 더하기

        JH_wallet = (current_money, current_stocks)

    if stock > prev:
        # 주식이 이전 가격보다 크다면
        state = (state[0]+1, 0)
    elif stock < prev:
        # 주식이 이전 가격보다 작다면
        state = (0, state[1]+1)
    
    # 상승, 하락 연속률이 3일 이상이면 행동
    if state[0] < 3 and state[1] < 3:
        continue

    # SM의 마지막 지갑 상태
    idx = len(SM_wallet) - 1

    if state[0] >= 3:
        # 상승이 3일 이상이라면 전량 매수
        current_money = SM_wallet[0] + SM_wallet[1] * stock 

        SM_wallet = (current_money, 0)
    elif state[1] >= 3:
        # 하락이 3일 이상이라면 전량 매도
        if SM_wallet[0] > stock and SM_wallet[0] > 0:
            # SM이 주식을 구매할 수 있다면
            stock_count = SM_wallet[0] // stock

            current_money = SM_wallet[0] - (stock * stock_count)
            current_stocks = stock_count + SM_wallet[1]

            SM_wallet = (current_money, current_stocks)

# 최종 가격
JH_money = JH_wallet[0] + JH_wallet[1] * stocks[len(stocks)-1]
SM_money = SM_wallet[0] + SM_wallet[1] * stocks[len(stocks)-1]

if JH_money > SM_money:
    print('BNP')
elif JH_money == SM_money:
    print('SAMESAME')
else:
    print('TIMING')