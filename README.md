# Resume Upload Application

## Overview
The **Resume Upload Application** is a simple web-based tool that allows users to upload and then parse their resumes. 

## Features
- Upload resumes in text format
- Error handling for invalid file formats and failed uploads
- User-friendly UI for easy interaction

## Technologies Used
- **Frontend:** HTML, CSS, React.js
- **Backend:** Java Spring Boot

## Installation
### Prerequisites
Ensure you have the following installed on your system:
- [Node.js](https://nodejs.org/)
- Git

### Setup
1. Clone this repository:
   ```sh
   git clone https://github.com/alexfaerman/resume-upload.git
   ```
2. Navigate to the project directory:
   ```sh
   cd resume-upload
   ```
3. Install dependencies:
   ```sh
   npm install   # If using Node.js backend
   ```
4. Start the server:
   ```sh
   npm start   # If using Node.js backend
   ```

## Usage
1. Open your browser and go to `http://localhost:8080/resume`
2. Click on the "Upload Resume" button.
3. Select a file from your computer.
4. Submit and wait for parsed section on the screen.


## API Endpoints (if applicable)
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST | `/upload` | Uploads a resume |


## Future Enhancements
- Implement resumable uploads for large files
- Add authentication to restrict access
- Integrate cloud storage (AWS S3, Firebase, etc.)
- Improve UI with progress indicators and validation feedback

