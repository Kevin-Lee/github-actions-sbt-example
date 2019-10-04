FROM kennethreitz/httpbin

CMD ["gunicorn", "-b", "0.0.0.0:8000", "-b", "0.0.0.0:8443", "httpbin:app", "-k", "gevent"]
