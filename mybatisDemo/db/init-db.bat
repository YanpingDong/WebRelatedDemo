echo 你确定要执行该操作吗? 如果数据库存在该表,则该表会被删除重建!!!
echo.
pause
echo.

cd %~dp0
cd ..

call mvn antrun:run -Pinit-db

cd db
pause