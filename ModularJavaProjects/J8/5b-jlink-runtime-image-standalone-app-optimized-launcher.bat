jlink --module-path "out;C:\apps\Java\jdk-17\jmods" --add-modules test.core.modul --output out-standalone-optimized --strip-debug --compress 2 --launcher fibo=test.core.modul/test.core.modul.Fibo

