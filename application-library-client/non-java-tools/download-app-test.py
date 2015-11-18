import requests

url = 'https://applib.goparatoolapi.com/uoapi/app/download'
headers = {'access_token' : '38030882-fa57-3eba-a757-ff56275a2a24',   'Content-Type' : 'application/json'}
r = requests.post(url,data=open('download-app-request.json','rb'),headers=headers)

print '===============================the headers================='
print r.headers


print '===============================the content================='

	
if r.headers['Content-Type'] == 'application/octet-stream':
	f = open('./binary-file', 'wb')
	f.write(r.content)
	f.close()
	print 'file has been downloaded as ./binary-file. Please rename it to as the following file name before you open it'
	print r.headers['Content-Disposition']
	
else:
	print r.content
	