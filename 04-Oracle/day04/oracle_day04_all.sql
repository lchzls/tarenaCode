�Ӳ�ѯ
�Ӳ�ѯҲ��һ����ѯ��䣬ֻ����Ƕ����
����SQL���֮�У�������Ϊ����SQL
�ṩ���ݡ�

�鿴��CLARK���ʸߵ�Ա��?
SELECT ename,sal
FROM emp
WHERE sal>(SELECT sal
          FROM emp
          WHERE ename='CLARK')

˭��SMITH��ͬ����?
SELECT ename,deptno
FROM emp
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='SMITH')

�鿴�ȹ�˾ƽ�����ʸߵ�Ա��?
SELECT ename,sal
FROM emp
WHERE sal>(SELECT AVG(sal)
           FROM emp)


�Ӳ�ѯҲ������DDL��DML��ʹ�á�
DDL��ʹ���Ӳ�ѯ:
����һ���Ӳ�ѯ�Ľ�������ٴ���һ�ű�
******************************
CREATE TABLE myemployee 
AS
SELECT e.empno,e.ename,e.job,
       e.deptno,d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno(+)

SELECT * FROM myemployee

DML��ʹ���Ӳ�ѯ
��SMITH��������Ա���������10%:
UPDATE emp
SET sal=sal*1.1
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='SMITH')

�鿴��ְλ��SALESMAN��ͬ����
������ְλԱ��?
SELECT ename,job,deptno
FROM emp
WHERE deptno IN (SELECT deptno
                 FROM emp
                 WHERE job='SALESMAN')
AND job <> 'SALESMAN'

***************************************
�鿴��ְλ��CLERK��SALESMAN���ʶ��ߵ�
Ա��?
SELECT ename,sal
FROM emp
WHERE sal > ALL(SELECT sal
                FROM emp
                WHERE job IN('CLERK','SALESMAN'))

EXISTS�ؼ���
EXISTS����Ҫ��һ���Ӳ�ѯ�������Ӳ�ѯ
�������ٲ�ѯ��һ����¼ʱ��EXISTS����
�档NOT EXISTS�����෴�Ĳ�����
(����dept������d.deptno��e.deptno���Ƿ����)
SELECT deptno, dname 
FROM dept d
WHERE EXISTS 
     (SELECT * FROM emp e
      WHERE d.deptno = e.deptno)


HAVING��ʹ���Ӳ�ѯ:
�鿴���нˮ����30�Ų������нˮ�Ĳ���?
SELECT MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING MIN(sal)>(SELECT MIN(sal)
                 FROM emp
                 WHERE deptno=30)


�����Ӳ�ѯ��������һ�ű�����������
FROM�Ӿ��С�
�鿴�����Լ�����ƽ�����ʵ�Ա��?
SELECT e.ename,e.sal,e.deptno
FROM emp e,
    (SELECT AVG(sal) avg_sal,deptno
     FROM emp
     GROUP BY deptno) t
WHERE e.deptno=t.deptno
AND e.sal>t.avg_sal

********************************
�Ӳ�ѯ�е��ֶ����Ǻ������߱��ʽ
��ô�����������
*********************************


SELECT�Ӿ���Ҳ����ʹ���Ӳ�ѯ��
SELECT 
 e.ename, e.sal, 
 (SELECT d.dname FROM dept d 
 WHERE d.deptno = e.deptno) dname
FROM emp e

��ҳ��ѯ
��ҳ��ѯ�ǽ���ѯ�����ݷֶ���ʾ
��������Ŀ�Ŀ��Լ�����Դռ�ã�
�����Ӧ�ٶȡ�
��ҳ�ڲ�ͬ�����ݿ��е�SQL�����
��һ����(����)

ORACLE�еķ�ҳ������α��:ROWNUMʵ�ֵ�
ROWNUM���������κα��У������κα�����
��ѯ���У����е�ֵʱ���Ų�ѯ���ݵĹ�����
���ɵģ�ֻҪ���Բ�ѯ��һ����¼����ôROWNUM
�ֶε�ֵ���Ǹü�¼���кţ���1��ʼ��

��ʹ��ROWNUM�Խ�������б�ŵĹ�����
��Ҫʹ��ROWNUM��>1���ϵĹ����жϣ�����
��������ò����κμ�¼
SELECT ROWNUM,ename,sal,deptno
FROM emp
WHERE ROWNUM >1

�鿴6-10��¼
SELECT *
FROM (SELECT 
       ROWNUM rn,ename,sal,deptno
      FROM emp)
WHERE rn BETWEEN 6 AND 10

�鿴��˾���������ĵ�6-10��:
SELECT *
FROM (SELECT 
       ROWNUM rn,ename,sal,deptno
      FROM emp)
WHERE rn BETWEEN 6 AND 10
ORDER BY sal DESC

���������ڲ�ѯ����е�ִ��˳��
����͵ģ����ԣ��ڷ�ҳ����������
����ʱ��Ӧ����������Ȼ���ٸ���
����Ľ�����з�ҳ��ѯ��
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT ename,sal,deptno
          FROM emp
          ORDER BY sal DESC) t)
WHERE rn BETWEEN 6 AND 10

*********************************************************************
������������ַ�������ѯЧ�ʸ��ߡ���ΪWHERE ROWNUM<=10����ֻ���ѯ10����
����������ȫ����ѯ����������Ҫע�⣬�����where���õ���ROWNUM��������
���ı�������Ϊ��
SELECT ROWNUM rn,t.*
     FROM(SELECT ename,sal,deptno
          FROM emp
          ORDER BY sal DESC) t
     WHERE ROWNUM<=10
 ����sql����У�����ִ��where����ִ��select��䣬��ʱ������û�����ɡ�

SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT ename,sal,deptno
          FROM emp
          ORDER BY sal DESC) t
     WHERE ROWNUM<=10)
WHERE rn >=6

����ҳ���Լ�ÿҳ��ʾ����Ŀ������
��Χ�Ĺ�ʽ:
pageSize:5   ÿҳ��ʾ����Ŀ��
page:2       ҳ��
start = (page-1)*pageSize+1
end = pageSize*page

javaα����:
int pageSize=5;
int page=2;
int start= (page-1)*pageSize+1;
int end = pageSize*page;

String sql = "SELECT * "+
             "FROM(SELECT ROWNUM rn,t.* "+
             "     FROM(SELECT ename,sal,deptno "+
             "          FROM emp "+
             "          ORDER BY sal DESC) t) "+
             "WHERE rn BETWEEN "+start+" AND "+end;

********************************
DECODE����
DECODE��������ʵ�ַ�֧��Ч������Ĭ��ֵ��д����ΪNULL��NULL�����ݿ��������ġ�

SELECT ename, job, sal,
     DECODE(job,  
            'MANAGER', sal*1.2,
            'ANALYST', sal*1.1,
            'SALESMAN', sal*1.05,
            sal) bonus
FROM emp


��������DECODE���ֶ�ֵ��һ���ļ�¼����
ͬһ�飬ֻ��Ҫ������һ��ļ�¼���ֶ�ֵ
�滻Ϊһ����ֵͬ���ɡ�
SELECT
  COUNT(*),DECODE(job,
           'MANAGER','VIP',
           'ANALYST','VIP',
           'OTHER')
FROM emp
GROUP BY DECODE(job,
         'MANAGER','VIP',
         'ANALYST','VIP',
         'OTHER')


���԰����Զ���˳������
SELECT deptno, dname, loc
FROM dept
ORDER BY 
    DECODE(dname, 
          'OPERATIONS',1,
          'ACCOUNTING',2,
          'SALES',3)


������
����������Խ�������ո������ֶη��飬
Ȼ�������ڰ���ָ�����ֶ�����Ȼ������
һ�����ڵı�š�
***********************************
ROW_NUMBER��������������Ψһ������
�鿴ÿ�����Ź�������
SELECT 
 ename,sal,deptno,
 ROW_NUMBER() OVER(
  PARTITION BY deptno
  ORDER BY sal DESC 
 ) rank
FROM emp

RANK:�������ڲ������Ҳ�Ψһ������
SELECT 
 ename,sal,deptno,
 RANK() OVER(
  PARTITION BY deptno
  ORDER BY sal DESC 
 ) rank
FROM emp

DENSE_RANK:����������������Ψһ������
SELECT 
 ename,sal,deptno,
 DENSE_RANK() OVER(
  PARTITION BY deptno
  ORDER BY sal DESC 
 ) rank
FROM emp

�߼����麯��
�߼����麯�����԰��ոú���Ҫ���
���鷽ʽ�����ݽ��з���ͳ�ƣ�Ȼ��
��Щ���鷽ʽͳ�ƵĽ������һ�������
����ʾ��
������ǰ��ղ�ͬ���鷽ʽ�ֱ�ͳ�ƽ��
����ʹ��UNION ALL����һ����д����
Ҫ���Ķࡣ

SELECT 
 year_id,month_id,
 day_id,sales_value
FROM
 sales_tab
ORDER BY
 year_id,month_id,day_id

�鿴ÿ��Ӫҵ��?
SELECT 
 year_id,month_id,
 day_id,SUM(sales_value)
FROM sales_tab
GROUP BY 
 year_id,month_id,day_id
ORDER BY
 year_id,month_id,day_id

ÿ��Ӫҵ��?
SELECT
 year_id,month_id,SUM(sales_value)
FROM sales_tab
GROUP BY
 year_id,month_id
ORDER BY
 year_id,month_id

ÿ��Ӫҵ��?
SELECT
 year_id,SUM(sales_value)
FROM sales_tab
GROUP BY
 year_id
ORDER BY
 year_id

������
SELECT
 SUM(sales_value)
FROM sales_tab


��һ��������У�����ÿ�죬ÿ�£�ÿ��
�Լ�������?
GROUP BY ROLLUP(a,b,c)
��ͬ��
GROUP BY a,b,c
UNION ALL
GROUP BY a,b
UNION ALL
GROUP BY a
UNION ALL
ȫ��

SELECT 
 year_id,month_id,
 day_id,SUM(sales_value)
FROM sales_tab
GROUP BY 
 ROLLUP(year_id,month_id,day_id)
ORDER BY
 year_id,month_id,day_id

GROUP BY CUBE(a,b,c)
��ͬ
a,b,c
a,b
a,c
b,c
a
b
c
ȫ��

SELECT 
 year_id,month_id,
 day_id,SUM(sales_value)
FROM sales_tab
GROUP BY 
 CUBE(year_id,month_id,day_id)
ORDER BY
 year_id,month_id,day_id

GROUPING SETS()
ÿ��������һ�ַ��鷽ʽ��Ȼ����Щ����
ͳ�ƵĽ������һ���������ʾ��
���ڷ��鷽ʽ����ͨ���������룬�������
ROLLUP,CUBE���ڶ����鷽ʽҪ��

�鿴ÿ����ÿ���Ӫҵ��?
SELECT 
 year_id,month_id,
 day_id,SUM(sales_value)
FROM sales_tab
GROUP BY 
 GROUPING SETS(
  (year_id,month_id),
  (year_id,month_id,day_id)
 )
ORDER BY
 year_id,month_id,day_id





