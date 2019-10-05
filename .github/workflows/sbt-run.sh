#! /bin/bash

set -ex

echo "============================================"
echo "Runing project"
echo "--------------------------------------------"
echo ""
cd /app
sbt clean run

echo "============================================"
echo "Runing project: Done"
echo "============================================"
