import axios from 'axios'
import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query'
import { type Task } from '../data/schema'

export type CreateTaskInput = Omit<Task, 'id'>

export type SearchTasksInput = {
  keyword?: string
  statuses?: string[]
  priorities?: string[]
  labels?: string[]
}

const tasksKey = ['tasks'] as const

async function searchTasks(input: SearchTasksInput) {
  const { data } = await axios.post<Task[]>('/api/tasks/search', input)
  return data
}

async function createTask(input: CreateTaskInput) {
  const { data } = await axios.post<Task>('/api/tasks', input)
  return data
}

export function useSearchTasks(input: SearchTasksInput = {}) {
  return useQuery({
    queryKey: [...tasksKey, 'search', input],
    queryFn: () => searchTasks(input),
  })
}

export function useCreateTask() {
  const queryClient = useQueryClient()
  return useMutation({
    mutationFn: createTask,
    onSuccess: () => queryClient.invalidateQueries({ queryKey: tasksKey }),
  })
}
