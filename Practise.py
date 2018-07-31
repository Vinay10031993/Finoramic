# Prerequisites :
# 1. Check version of pip: It should be 9.3.0


import sys, os,json
import pip
class Script:

	def __init__(self):
		self.cmd="pip install "
		self.dicElem={}
		self.existdicts={}
		self.dict3={}


#  retrive data from the .json file
	def getData(self,name):
		f=open(name,'r')
		data=json.load(f);
		self.dicElem=data.get("Dependencies")
		f.close()
#  Get the existing dependencies 
	def getExistedDependencies(self):
		
		installed_packages = pip.get_installed_distributions(local_only=True)
		installed_packages_list = sorted(["%s==%s" % (i.key, i.version)
			for i in installed_packages])

		for ele in installed_packages_list:
			var=ele.split("==")
			self.existdicts[var[0]]=var[1]

#  Install the dependencies mentioned in the json file
	def getJsonDependenciesInstalled(self):
		for key,val in self.dicElem.items():
			os.system(self.cmd+str(key)+"=="+str(val))

#  Check for any uninstalled dependencies
	def checkAnyUninstalled(self,):
		for i,j in self.dicElem.items():
			if i in self.existdicts:
				if j==self.dicElem[i]:
					print(i+" is successfully installed\n")
				else:
					self.dict3[i]=j;
			else:
				self.dict3[i]=j;

		print("################################################################################\n")
		print("***********************Install Failed Dependencies*******************************\n")
		for k,v in self.dict3.items():
			print(k+" of version "+v+" not installed")
		print("################################################################################")


if __name__ == '__main__':
	obj=Script()

	# Method to get data from .json file
	obj.getData("Dependencies.json")

	# Method to get existing Dependencies
	obj.getExistedDependencies()

	# Method to install the dependencies mentioned in .json file
	obj.getJsonDependenciesInstalled()

	# Method to check installations have been sucessful of not.
	obj.checkAnyUninstalled()