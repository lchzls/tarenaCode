��ݼ���
ʹ��ctrl+enter���Ϳ��Կ���ִ��sql��䣬ǰ���ǣ���sql������Ҫ����;���򣬿�ݼ�����Ч
SELECT SYSDATE FROM dual;

ѡ��Ҫע�͵��У�Ȼ��ctrl+/,����һ����ע�͵�sql���

���ֺõ�ϰ�ߣ�д�����ݿ⣬Ȼ�����;������


--������employee
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1),
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

�鿴��ṹ
DESC table_name
DESC employee

ɾ����
DROP TABLE table_name
DROP TABLE employee

���ݿ��������ֶε�Ĭ��ֵ����NULL��
����������ʱ��ĳ���ֶ�û�и�ֵ��
ʱ����ὫNULLֵ��Ϊ���ֶε�ֵ
����ͨ��DEFAULT�ؼ���Ϊָ�����ֶ�
����һ��ָ����Ĭ��ֵ��
�����ַ��������������ԣ������ݿ���
��ʹ�õ������������ġ�
SQL��䲻���ִ�Сд��������������ֵ
�����ִ�Сд�ģ�

CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20) NOT NULL,
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2) DEFAULT 5000,
  job VARCHAR2(30),
  deptno NUMBER(2)
);

DESC employee

�޸ı�
1:�޸ı���
2:�޸ı�ṹ

�޸ı���
RENAME old_name TO new_name
RENAME employee TO myemp

DESC myemp

2:�޸ı�ṹ
2.1:������ֶ�
��ӵ��ֶ�ֻ�ܱ���ӵ����ĩβ��
ALTER TABLE myemp 
ADD(
  hiredate DATE DEFAULT SYSDATE
)
DESC myemp

2.2�޸ı��������ֶ�
�޸�ֻ���޸��ֶε����ͣ����ȣ�
Ĭ��ֵ�Լ��Ƿ�ǿ�
�ò����������ڱ����Ѿ���������
������½��У������п����޸Ĳ��ɹ���
����:�������޸��ֶ����ͣ��޸ĳ���
�������Ӷ����Ǽ��١�
ALTER TABLE myemp
MODIFY(
  job VARCHAR2(40)
)

DESC myemp

2.3ɾ�������ֶ�
ALTER TABLE myemp
DROP(hiredate)

DESC myemp




DML���
�Ա������ݽ��в���
����:��ɾ�Ĳ���
DML�ǰ��������

INSERT���
����в�������
INSERT INTO myemp
(id,name,job,deptno)
VALUES
(1,'jack','CLERK',10)
COMMIT �ύ����
ROLLBACK  �ع�����

SELECT * FROM myemp

����ָ���ֶΣ�����ȫ�в���
INSERT INTO myemp
VALUES
(2,'rose','F',SYSDATE,5000,'CLERK',20)

�������ڽ���ʹ�����ú���
TO_DATE,��ȻҲ����ʹ��
�ַ��������Ǹ�ʽ������ѭ:
DD-MON-RR,���������Բ���
������ֻ��
INSERT INTO myemp
(id,name,deptno,birth)
VALUES
(3,'mike',20,
 TO_DATE('1992-08-02',
         'YYYY-MM-DD')
)
SELECT * FROM myemp

UPDATE���
�޸ı�������
UPDATE myemp
SET salary=8000,deptno=30
WHERE gender='M'

DELETE���
ɾ����������
DELETE FROM myemp
WHERE gender='M'

UPDATE��DELETEͨ������Ҫ���WHERE����
������ǶԱ����������ݽ��еĲ���!






