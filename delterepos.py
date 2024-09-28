import subprocess

# Function to delete a GitHub repository
def delete_repo(repo_name):
    try:
        # Run the gh command to delete the repository
        subprocess.run(["gh", "repo", "delete", repo_name, "--confirm"], check=True)
        print(f"Deleted repository: {repo_name}")
    except subprocess.CalledProcessError as e:
        print(f"Error deleting repository {repo_name}: {e}")

# Function to process the file and delete repositories
def delete_repos_from_file(file_path):
    with open(file_path, 'r') as file:
        for line in file:
            # Extract the repository name (first part of the line)
            repo_name = line.split('\t')[0]
            delete_repo(repo_name)

# Specify the path to your file
file_path = "listrepo2.txt"
delete_repos_from_file(file_path)
