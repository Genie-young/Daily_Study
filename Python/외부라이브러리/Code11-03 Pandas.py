import pandas as pd
df = pd.read_csv("C:/PythonExample/CSV/01_data.csv")  #2차원 구조의 표를 그 자체로 불러옴.
type(df)
sr = df.Name #df는 시리즈로 구성

df_Name = df['Name']; df_Name = df.Name;  #동일한 표현
df_Name_Country  = df[['Name','Country']]
df_row_0 = df.loc[0] #<class 'pandas.core.series.Series'
df_row_0_3 = df.loc[[0,3]] #0행부터 2행까지
df_row_2to5 = df.loc[2:5]

#df_col_0

df_Con_group = df.groupby("Country")