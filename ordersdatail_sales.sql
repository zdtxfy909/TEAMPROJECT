-- ordersdetail (주문 상세 조회) 테이블 조인
SELECT o.orderid, o.custid, J.name, o.totalprice, s.count, s.orderdate
FROM ORDERS O
   , SALES S
   , (SELECT ODT.ORDERID, M.NAME, M.PRICE 
        FROM ordersdetail ODT, MENU M 
        WHERE odt.menuid = m.menuid) J
WHERE O.ORDERID = S.ORDERID
  AND O.ORDERID = J.ORDERID
  order by o.orderid
;

--sales 일매출 조회
select TO_CHAR(s.orderdate, 'yyyy-mm-dd') as day
     , sum(s.totalprice) as "DAILY_SALES"
from sales s
group by TO_CHAR(s.orderdate, 'yyyy-mm-dd')
;

--sales 월매출 조회
select TO_CHAR(s.orderdate, 'yyyy-mm') as MONTH
     , sum(s.totalprice) as "MONTH_SALES"
from sales s
group by TO_CHAR(s.orderdate, 'yyyy-mm')
;

--sales 연매출 조회
select TO_CHAR(s.orderdate, 'yyyy') as YEAR
     , sum(s.totalprice) as "YEAR_SALES"
from sales s
group by TO_CHAR(s.orderdate, 'yyyy')
;

select *
from sales
;