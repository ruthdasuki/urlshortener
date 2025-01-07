export const isValidUrl = (url) => {
    const urlRegex = /^(https?:\/\/)?([a-zA-Z0-9-]+\.)+[a-zA-Z]{2,}(:\d+)?(\/.*)?$/
    return urlRegex.test(url)
}

export const isValidEmail = (email) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

export const calculateDaysAgo = (timestamp: string | undefined): string => {
    if (!timestamp) return "Never"

    const lastAccessedDate = new Date(Number(timestamp))
    const now = new Date()
    const differenceInMilliseconds = now.getTime() - lastAccessedDate.getTime()
    const differenceInDays = Math.floor(differenceInMilliseconds / (1000 * 60 * 60 * 24))
    return `${differenceInDays} days ago`
};