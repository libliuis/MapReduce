#include<bits/stdc++.h>
using namespace std;

void final_result(map<string,int> &sff){
	map<string, int>::iterator ite = sff.begin();
	freopen("d:/hamletout.txt","w",stdout);
	for(;ite!=sff.end();ite++) {
        cout << ite->first << " " << ite->second << endl;
    }
}

void reducing(map<string,int> &sff){
	cout<<"开始reducing!"<<endl;
	cout<<"结束reducing!"<<endl;
	cout<<"最终结果输出"<<endl;
	final_result(sff);
}

void shuffling(vector<pair<string,int> > &vpsmapping){
	cout<<"开始shuffling!"<<endl;
	map<string,int> sff;
	for(int i=0;i<vpsmapping.size();i++){
		sff[vpsmapping[i].first]++;
	}
	cout<<"结束shuffling!"<<endl;
	reducing(sff);
}

void mapping(vector<string> &spwords){
	cout<<"开始mapping!"<<endl;
	vector<pair<string,int> > vpsmapping;
	for(int i=0;i<spwords.size();i++){
		vpsmapping.push_back(make_pair(spwords[i],1));
	}
	cout<<"结束mapping!"<<endl;
	shuffling(vpsmapping);
}

void splitting(string &buf){
	cout<<"开始splitting!"<<endl;
	vector<string> spwords;
	for(int i=0;i<buf.size();i++){
		string tmp = "";
		int j=i;
		while(buf[j]>='A'&&buf[j]<='Z'||buf[j]>='a'&&buf[j]<='z'){
            if(buf[j]>='A'&&buf[j]<='Z')buf[j]+=32;
			tmp+=buf[j];
			j++;
		}
		if(tmp!="")spwords.push_back(tmp);
		i=j;
	}
	cout<<"结束splitting!"<<endl;
	mapping(spwords);
}



int main(){
	cout<<"开始读取文件!"<<endl;
    ifstream  in("d:/Hamlet.txt");
    ostringstream  tmp;
    tmp  <<  in.rdbuf();
    string  buf  =  tmp.str();
    cout<<"读取结束！"<<endl;
    splitting(buf);
    return 0;
}
#include<bits/stdc++.h>
using namespace std;

void final_result(map<string,int> &sff){
	map<string, int>::iterator ite = sff.begin();
	freopen("d:/hamletout.txt","w",stdout);
	for(;ite!=sff.end();ite++) {
        cout << ite->first << " " << ite->second << endl;
    }
}

void reducing(map<string,int> &sff){
	cout<<"开始reducing!"<<endl;
	cout<<"结束reducing!"<<endl;
	cout<<"最终结果输出"<<endl;
	final_result(sff);
}

void shuffling(vector<pair<string,int> > &vpsmapping){
	cout<<"开始shuffling!"<<endl;
	map<string,int> sff;
	for(int i=0;i<vpsmapping.size();i++){
		sff[vpsmapping[i].first]++;
	}
	cout<<"结束shuffling!"<<endl;
	reducing(sff);
}

vector<pair<string,int> > mapping(vector<string> &spwords){
	cout<<"开始mapping!"<<endl;
	vector<pair<string,int> > vpsmapping;
	for(int i=0;i<spwords.size();i++){
		vpsmapping.push_back(make_pair(spwords[i],1));
	}
	cout<<"结束mapping!"<<endl;
	return vpsmapping;
}

vector<pair<string,int> > splitting(string &buf){
	cout<<"开始splitting!"<<endl;
	vector<string> spwords;
	for(int i=0;i<buf.size();i++){
		string tmp = "";
		int j=i;
		while(buf[j]>='A'&&buf[j]<='Z'||buf[j]>='a'&&buf[j]<='z'){
            if(buf[j]>='A'&&buf[j]<='Z')buf[j]+=32;
			tmp+=buf[j];
			j++;
		}
		if(tmp!="")spwords.push_back(tmp);
		i=j;
	}
	cout<<"结束splitting!"<<endl;
	return mapping(spwords);
}



int main(){
	cout<<"开始读取文件!"<<endl;
    ifstream  in("d:/Hamlet.txt");
    ostringstream  tmp;
    tmp  <<  in.rdbuf();
    string  buf  =  tmp.str();
    cout<<"读取结束！"<<endl;
    int sindex = int(buf.size())/3;
    for(;sindex<buf.size();sindex++){
        if(buf[sindex]==' ')break;
    }
    string str1 = buf.substr(0,sindex);
    int sindex2=sindex+int(buf.size())/3;
    for(;sindex2<buf.size();sindex2++){
        if(buf[sindex2]==' ')break;
    }
    string str2 = buf.substr(sindex,sindex2-sindex);
    string str3 = buf.substr(sindex2, int(buf.size())-sindex2);

    //三部分进行splitting 和 mapping
    vector<pair<string,int> > vps1 = splitting(str1);
    vector<pair<string,int> > vps2 = splitting(str2);
    vector<pair<string,int> > vps3 = splitting(str3);
    vps1.insert(vps1.end(),vps2.begin(),vps2.end());
    vps1.insert(vps1.end(),vps3.begin(),vps3.end());
    shuffling(vps1);
    return 0;
}
