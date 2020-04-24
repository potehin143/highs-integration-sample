#!/bin/sh
#

cp -f /mnt/src/target/*.jar /opt/app/
#cp /mnt/bin/* /lib
cp /mnt/bin/libhighs /lib/libhighs.so.1.0.0
cp /mnt/bin/libipx /lib/libipx.so
cp /mnt/bin/libbasiclu /lib/libbasiclu.so
cp /mnt/bin/libgomp /lib/libgomp.so.1.0.0

ldconfig -n -v /lib
echo "library installation complete successfull"
exec "$@"
