call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo calling runcrud.bat has errors - breaking work
goto fail

:browser
start /max http://localhost:8080/crud/v1/task/getTasks

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.