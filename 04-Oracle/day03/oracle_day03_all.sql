�еı���
��һ��SELECT�Ӿ��е��ֶ���һ������
���߱��ʽʱ����ô������ж�Ӧ�ĸ��ֶ�
�����־��������������ʽ���ɶ��Բ
��ʱ����Ϊ���ֶ�ָ��������
��������ʹ��˫���������������ִ�Сд
����ӿո�
SELECT 
 ename,sal*12 sal,
 TO_CHAR(hiredate,'YYYY-MM-DD') hiredate
FROM emp

WHERE�ڲ�ѯ����������ӹ��������ģ�
���Ĺ���ʱ�����ڲ�ѯ��Ĺ����н���
�ģ�ÿ����������һ������ʱ�ͻ���
���Ƿ�����WHERE������������ᱻ��ѯ
�������������򱻺��ԡ�


AND��OR���������Ӷ�����������ģ�����
AND�����ȼ��Ǹ���OR�ġ�

�鿴���ʸ���1000��ְλ��CLERK��SALESMAN
��Ա����Ϣ
SELECT ename,job,sal
FROM emp
WHERE sal>1000
AND (job='SALESMAN'
OR job='CLERK')

LIKE����ģ��ƥ���ַ�����֧������ͨ���:
_:��ʾ�����һ���ַ�
%:��ʾ������ַ�

�鿴���ֵ�������ĸ��L��Ա��
SELECT ename,sal,deptno
FROM emp
WHERE ename LIKE '__L%'

IN��NOT IN���ж��Ƿ����б�
�л��߲������б���
IN��NOT INͨ�������Ӳ�ѯ
SELECT ename, job FROM emp  
WHERE job IN ('MANAGER', 'CLERK');

SELECT ename, job FROM emp 
WHERE deptno NOT IN (10, 20);

BETWEEN...AND...
�ж��Ƿ���һ����Χ��
SELECT ename, sal FROM emp  
WHERE sal BETWEEN 1500 AND 3000

*******************************
ANY��ALL�������ж�һ��ֵ�Ƿ�
>,>=,<,<=�б��е�����
>ALL(list):�����б�������
<ALL(list):С���б�����С��
>ANY(list):�����б�����С��
<ANY(list):С���б�������
AND��ALL���б�ͨ���������ȷ����
ֵ���������һ���Ӳ�ѯʹ�á�
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE sal > ANY (3500,4000,4500);


DISTINCT�ؼ���
���ڽ��������ָ�����ֶε��ظ�
��¼ȥ����DISTINCTӦ��������
SELECT�ؼ���֮�󣬿��ԶԵ���
ȥ��Ҳ���ԶԶ���ȥ�ء�

�鿴��˾��ְλ����Щ��
SELECT DISTINCT job
FROM emp

���ֶ�ȥ�أ�����֤ÿ���ֶ�û���ظ�
ֵ�����������Щ�ֶ�ֵ�����û���ظ�
��¼��
SELECT DISTINCT job,deptno
FROM emp

��������
ORDER BY�Ӿ���Խ���ǰ�����
���ո������ֶε�ֵ�����������
�������С�
ORDER BY�Ӿ�ֻ��д��DQL����
���һ���Ӿ��ϡ�
ASC:����(Ĭ�Ͼ�������ͨ����д)
DESC:����

�鿴��˾�й��ʵ�����
SELECT ename,sal,deptno
FROM emp
ORDER BY sal DESC

*********************
������ֶ���������NULLֵ����ôNULL
���������ֵ��
���ս�������
SELECT ename,sal,comm
FROM emp
ORDER BY comm DESC

���ֶ�����
����������ȼ����Ȱ��յ�һ���ֶ�����
�����������һ���ֶε�ֵ���ظ���ʱ��
�ŻὫ��Щ��¼�а��յڶ����ֶε�����
������������Դ����ơ�
ÿ���ֶζ���Ҫ����ָ������ʽ��
SELECT ename,deptno,sal
FROM emp
ORDER BY deptno DESC,sal DESC

�ۺϺ������ֳ�Ϊ���к��������麯��
�ۺϺ���������ͳ�Ƶģ����Խ�������¼
��ָ�����ֶ�ֵ����ͳ�ƣ�Ȼ��õ�һ��
�����
MAX(),MIN()
ͳ�����ֵ����Сֵ
SELECT MAX(sal),MIN(sal)
FROM emp

AVG(),SUM()
��ƽ��ֵ���ܺ�
SELECT AVG(sal),SUM(sal)
FROM emp

COUNT()
ͳ�Ƽ�¼��
SELECT COUNT(ename)
FROM emp

*********************
�ۺϺ������Ǻ���NULLֵ�ġ�
SELECT COUNT(comm)
FROM emp

ͨ��ͳ�Ʊ��м�¼������ʹ��
SELECT COUNT(*) FROM emp

SELECT SUM(comm),AVG(comm)
FROM emp

SELECT AVG(NVL(comm,0))
FROM emp

GROUP BY�Ӿ�
GROUP BY���Խ���ǰ��ѯ�Ľ����
����GROUP BY�Ӿ�������ֶε�ֵ
��ͬ�ļ�¼����Ϊһ���飬��Ͼۺ�
�������Խ��и�ϸ�ֵ�ͳ�ƹ�����
�鿴ÿ�����ŵ�ƽ������?
SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno

SELECT MAX(sal),job
FROM emp
GROUP BY job

**************************************
��SELECT�Ӿ��г����˾ۺϺ�������ô
�����ھۺϺ����е������ֶα��������
GROUP BY�Ӿ��У����������Ǳ���ġ�
ͨ����ʹ�þۺϺ�����û��Ҫʹ��GROUP BY

GROUP BY���ݶ��ֶη���
����ԭ���ǽ�������У�GROUP BYָ����
��Щ�ֶε�ֵ�������ͬ�ļ�¼����һ��

�鿴ÿ������ÿ��ְλ���ж�����?
SELECT COUNT(*),job,deptno
FROM emp
GROUP BY job,deptno

�鿴����ƽ�����ʸ���2000����Щ
���ŵľ���ƽ���������Ƕ���?
SELECT AVG(sal),deptno
FROM emp
WHERE AVG(sal)>2000
GROUP BY deptno

WHERE�в��������ɾۺϺ�����ԭ��
���ڹ��˵�ʱ�������ԡ�
�ۺϺ�����ͳ���ǽ����ڽ�����Ļ���
֮�ϵģ����˵����ͳ��ǰ������Ӧ��
�Ѿ���ѯ�����������˽��������WHERE
�Ĺ��˾����ڲ�ѯ���ɽ�����Ĺ�����
���еġ�����WHERE��ǰ��ͳ���ں�
���Բ�����WHERE��ʹ�þۺϺ������й��ˡ�

HAVING�Ӿ�
HAVING�Ӿ����ʹ�þۺϺ����Ľ������
���ˡ�HAVING�����GROUP BY����ģ�
Ŀ���Ǹ��ݹ�������ȡ��ĳЩ����ļ�¼��
HAVING�������GROUP BY֮�󡣲��ܵ���
���塣
SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

�鿴ƽ�����ʸ���2000����Щ���ŵ�
��߹��ʺ���͹��ʶ��ֱ��Ƕ���?
SELECT MAX(sal),MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

������ѯ
���϶��ű���в�ѯ��������е��ֶ�
�������Զ����
������ѯҪ����������������ݿ����
��������������ļ�¼�������ߣ��Ӷ�
��ȡ��Щ��¼�ж�Ӧ��ѯ���ֶ�ֵ����
����������������������������ѿ���
������ͨ����һ��������Ľ������

�鿴ÿ��Ա���Լ��䲿����Ϣ
SELECT e.ename,e.job,
       e.deptno,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno

�������������������ѿ�����
�ѿ������ļ�¼�������������ѯ
�ı�ļ�¼���ĳ˻���
�Ὣ���ÿһ����¼����һ�ű��
ÿ����¼����һ�β�����һ����¼
SELECT e.ename,d.dname
FROM emp e,dept d

ͨ��N�ű������ѯ��Ҫ������N-1��
����������

������ѯ�е���������Ҫ���������
ͬʱ������
�鿴��NEW YORK������Ա��?
SELECT e.ename,e.job,
       d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND d.loc='NEW YORK'

������
������Ҳ�ǹ�����ѯ��һ��
�鿴��NEW YORK������Ա��?
SELECT e.ename,e.job,
       d.dname,d.loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE 
   d.loc='NEW YORK'

���������������ļ�¼�ǲ�������ڽ�����е�

������
�������ڽ��й�����ѯʱ���˻Ὣ������������
�ļ�¼�г�����Ҳ�Ὣ���������������ļ�¼
�г�����
�����ӷ�Ϊ:
��������:��JOIN������Ϊ������(��Ҫ��ʾ��¼�ı�)
        �ñ��е����м�¼��Ҫ��ʾ��������ĳ����¼
        ��������������ʱ��������¼������JOIN�Ҳ�
        ���е��ֶ�ȫ����NULL��Ϊֵ��
�������ӣ�ȫ������

SELECT e.ename,e.job,d.dname
FROM emp e 
LEFT|RIGHT|FULL OUTER JOIN 
dept d
ON e.deptno=d.deptno

������
�����ӱ���������ǵ�ǰ���һ����¼
���Զ�Ӧ��ǰ��Ķ�����¼
����������ڽ����¼������ͬ����¼��
�ִ������¼���ϵ����״�ṹʱʹ�á�

�鿴ÿ��Ա���Լ�����˾������?
SELECT e.ename,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno

SELECT e.ename,m.ename
FROM emp e JOIN emp m
ON e.mgr=m.empno

�鿴SMITH����˾���ĸ�����?
SELECT e.ename,m.ename,d.loc
FROM emp e JOIN emp m
ON e.mgr = m.empno
JOIN dept d
ON m.deptno = d.deptno
WHERE e.ename='SMITH'

SELECT e.ename,m.ename,d.loc
FROM emp e,emp m,dept d
WHERE e.mgr = m.empno
AND m.deptno = d.deptno
AND e.ename='SMITH'








