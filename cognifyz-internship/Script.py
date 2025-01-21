import pandas as pd
import matplotlib.pyplot as plt
import statistics as stats
import seaborn as sns
import time

# TASK 1
print(f"\n\n{'*' * 10} TASK-1 {'*' * 10}\n")
file = "Data_set 2 - Copy.csv"
data = pd.read_csv(file)
noOfEntries = data.shape[0]
print(f"The number of entries in the dataset are {noOfEntries}.")
noOfColumns = data.shape[1]
print(f"\nThe number of columns in the dataset are {noOfColumns}.")
dataTypes = data.dtypes
print(f"""\nThe datatypes in the dataset are:
COLUMN NAME{"\t" * 7}DATA TYPE
{dataTypes}""")
print("\nADDITIONAL INFORMATION:")
data.info()
time.sleep(7)

# TASK 2
print(f"\n\n{'*' * 10} TASK-2 {'*' * 10}\n")
genderCount = data["gender"].value_counts()
fig, axes = plt.subplots(1, 2)
genderCount.plot(kind="bar", color=["blue", "pink"], ax=axes[0])
axes[0].set_title("Distribution of Genders: Bar Graph")
axes[0].set_xlabel("Gender")
axes[0].set_ylabel("Distribution")
genderCount.plot(kind="pie", colors=["blue", "pink"], ax=axes[1])
axes[1].set_title("Distribution of Genders: Pie Chart")
axes[1].set_ylabel('')
plt.tight_layout()
plt.show()

# TASK 3
print(f"\n\n{'*' * 10} TASK-3 {'*' * 10}\n")
numericalColumns = data.select_dtypes(include=["int64", "float64"])
print("\nNUMERICAL COLUMNS AND THEIR STATISTICAL ANALYSIS:")
for i in numericalColumns:
    column = data[i]
    print(f"\nCOLUMN {i}:")
    print(f"Mean of the {i} values is: {stats.mean(column):.3f}")
    print(f"Median of the {i} values is: {stats.median(column):.3f}")
    print(f"Standard deviation of the {i} values is: {stats.stdev(column):.3f}")
time.sleep(3)

# TASK 4
print(f"\n\n{'*' * 10} TASK-4 {'*' * 10}\n")
investmentColumns = ["Mutual_Funds", "Equity_Market", "Debentures", "Government_Bonds", "Fixed_Deposits", "PPF", "Gold"]
investment = data[investmentColumns].sum()
maxInvestment = investment.idxmax()
maxInvestmentCount = investment.max()
print(f"\nThe most frequent investment avenue is {maxInvestment} with a frequency of {maxInvestmentCount}.")
time.sleep(2)

# TASK 5
print(f"\n\n{'*' * 10} TASK-5 {'*' * 10}\n")
reasonColumns = ["Reason_Equity", "Reason_Mutual", "Reason_Bonds", "Reason_FD"]
allReasons = pd.concat([data[i] for i in reasonColumns])
reasonCounts = allReasons.value_counts()
print(f"\nThe top 10 most common reasons for investment choices are as follows:\nREASONS{"\t" * 5}FREQUENCY")
print(reasonCounts.head(10))
time.sleep(3)

# TASK 6
print(f"\n\n{'*' * 10} TASK-6 {'*' * 10}\n")
savingObjectivesCount = data["What are your savings objectives?"].value_counts()
print(f"\nThe main objectives and their frequency are:\n{savingObjectivesCount.to_string()}")
time.sleep(3)

# TASK 7
print(f"\n\n{'*' * 10} TASK-7 {'*' * 10}\n")
sourceColumnCount = data["Source"].value_counts()
print(f"\nThe most common source is {sourceColumnCount.idxmax()}")
time.sleep(2)

# TASK 8
print(f"\n\n{'*' * 10} TASK-8 {'*' * 10}\n")
durationMap = {"Less than 1 year": 0.5, "1-3 years": 2, "3-5 years": 4, "More than 5 years": 6}
data["Duration_Numerical"] = data["Duration"].map(durationMap)
averageDuration = data["Duration_Numerical"].mean()
print(f"\nThe average investment duration is {averageDuration:.2f} years.")
time.sleep(2)

# TASK 9
print(f"\n\n{'*' * 10} TASK-9 {'*' * 10}\n")
expectColumnCount = data["Expect"].value_counts()
print(expectColumnCount)
time.sleep(3)

# TASK 10
print(f"\n\n{'*' * 10} TASK-10 {'*' * 10}\n")
data["Expected_Returns"] = data["Expect"].str.extract(r"(\d+)-").astype(float)
correlationData = data[["age", "Duration_Numerical", "Expected_Returns"]]
correlationMatrix = correlationData.corr()
plt.figure(figsize=(8, 6))
sns.heatmap(correlationMatrix, annot=True, cmap="coolwarm", fmt=".2f")
plt.title("Correlation Matrix")
plt.show()
sns.pairplot(correlationData, diag_kind="kde", kind="scatter", plot_kws={"alpha": 0.7})
plt.show()
